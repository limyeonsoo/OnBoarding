package com.sds.mvcOnboarding.repository.springData;

import com.sds.mvcOnboarding.domain.Task;
import com.sds.mvcOnboarding.domain.TaskStatus;
import com.sds.mvcOnboarding.repository.TaskEntity;
import com.sds.mvcOnboarding.repository.TaskRepository;
import com.sds.mvcOnboarding.service.TodoCreateAttributes;
import com.sds.mvcOnboarding.service.TodoModifyAttributes;
import com.sds.mvcOnboarding.service.TodoService;

import java.time.Clock;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class TodoSpringDataService implements TodoService {
    private final TaskRepository taskRepository;
    private final Clock clock;

    TodoSpringDataService(
            final TaskRepository taskRepository,
            final Clock clock) {
        this.taskRepository = Objects.requireNonNull(taskRepository);
        this.clock = Objects.requireNonNull(clock);
    }

    @Override
    public int create(final TodoCreateAttributes attributes) {
        final var now = clock.instant();
        final var savedTask = taskRepository.save(toEntityWithInstant(attributes, now));
        return fromEntity(savedTask).getId();
    }

    @Override
    public Task retrieve(final int id) {
        throw new RuntimeException("not implement");
    }

    @Override
    public List<Task> retrieveAll() {
        return taskRepository.findAll().stream()
                .map(TodoSpringDataService::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Task modify(final TodoModifyAttributes attributes) {
        final var now = clock.instant();
        final var asIs = taskRepository.findById(attributes.getId());
        if (asIs.isEmpty()) {
            throw new RuntimeException("invalid id");
        }
        final var toBe = new TaskEntity(
                asIs.get().getId(),
                asIs.get().getMember_id(),
                Objects.requireNonNullElse(attributes.getContent(), asIs.get().getContent()),
                Objects.requireNonNullElse(attributes.getStatus(), asIs.get().getStatus()),
                asIs.get().getCreate_date(),
                now.getEpochSecond()
        );
        return fromEntity(taskRepository.save(toBe));
    }

    @Override
    public void delete(final int id) {
        taskRepository.deleteById(id);
    }

    private static Task fromEntity(final TaskEntity entity) {
        return new Task(
                entity.getId(),
                entity.getMember_id(),
                entity.getContent(),
                TaskStatus.valueOf(entity.getStatus()),
                entity.getCreate_date(),
                entity.getModify_date()
        );
    }

    private static TaskEntity toEntityWithInstant(
            final TodoCreateAttributes todoCreateAttributes,
            final Instant instant) {
        return new TaskEntity(
                todoCreateAttributes.getMember_id(),
                todoCreateAttributes.getContent(),
                TaskStatus.ACTIVE.name(),
                instant.getEpochSecond(),
                instant.getEpochSecond()
        );
    }
}

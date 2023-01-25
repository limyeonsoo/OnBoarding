package com.sds.mvcOnboarding.repository.springData;

import com.sds.mvcOnboarding.domain.Task;
import com.sds.mvcOnboarding.repository.TaskEntity;
import com.sds.mvcOnboarding.repository.TaskRepository;
import com.sds.mvcOnboarding.service.TodoCreateAttributes;
import com.sds.mvcOnboarding.service.TodoModifyAttributes;
import com.sds.mvcOnboarding.service.TodoService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class TodoSpringDataService implements TodoService {
    private final TaskRepository taskRepository;

    TodoSpringDataService(final TaskRepository taskRepository) {
        this.taskRepository = Objects.requireNonNull(taskRepository);
    }

    @Override
    public int create(final TodoCreateAttributes attributes) {
        throw new RuntimeException("not implement");
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
        throw new RuntimeException("not implement");
    }

    @Override
    public void delete(final int id) {
        throw new RuntimeException("not implement");
    }

    private static Task fromEntity(final TaskEntity entity) {
        return new Task(
                entity.getId(),
                entity.getMember_id(),
                entity.getContent(),
                entity.getStatus(),
                entity.getCreate_date(),
                entity.getModify_date()
        );
    }
}

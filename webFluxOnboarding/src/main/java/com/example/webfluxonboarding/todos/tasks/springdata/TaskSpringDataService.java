package com.example.webfluxonboarding.todos.tasks.springdata;

import com.example.webfluxonboarding.todos.tasks.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.function.Supplier;

record TaskSpringDataService(
        TaskSpringDataRepository taskSpringDataRepository,
        Supplier<UUID> uuidGenerator
) implements TaskService {

    @Override
    public Mono<Task> insert(
            final TaskAttributesInsert taskAttributesInsert) {
        return taskSpringDataRepository.save(toEntity(taskAttributesInsert, true))
                .map(TaskSpringDataService::toTask);
    }

    @Override
    public Mono<Void> delete(
            final UUID taskId) {
        throw new RuntimeException("not implement");
    }

    @Override
    public Mono<TaskAttributes> update(
            final UUID taskId,
            final TaskAttributes taskAttributes) {
        throw new RuntimeException("not implement");
    }

    @Override
    public Mono<TaskAttributes> patch(
            final UUID taskId,
            final TaskAttributesPatch taskAttributesPatch) {
        throw new RuntimeException("not implement");
    }

    @Override
    public Mono<Task> select(
            final UUID taskId) {
        return taskSpringDataRepository.findById(taskId.toString())
                .map(TaskSpringDataService::toTask);
    }

    @Override
    public Flux<Task> selectAll() {
        return taskSpringDataRepository.findAll()
                .map(TaskSpringDataService::toTask);
    }

    private static Task toTask(final TaskEntity taskEntity) {
        return new Task(
                taskEntity.getId(),
                taskEntity.getDetails(),
                taskEntity.getTaskStatus()
        );
    }

    private TaskEntity toEntity(
            final TaskAttributesInsert taskAttributesInsert,
            final boolean isNewTask) {
        return new TaskEntity(
                uuidGenerator.get(),
                taskAttributesInsert.details(),
                TaskStatus.ACTIVE,
                isNewTask
        );
    }
}

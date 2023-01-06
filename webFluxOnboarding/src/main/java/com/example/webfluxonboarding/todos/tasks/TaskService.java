package com.example.webfluxonboarding.todos.tasks;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TaskService {
    Mono<Task> insert(TaskAttributesInsert taskAttributesInsert);

    Mono<Void> delete(UUID taskId);

    Mono<TaskAttributes> update(UUID taskId, TaskAttributes taskAttributes);

    Mono<TaskAttributes> patch(UUID taskId, TaskAttributesPatch taskAttributesPatch);

    Mono<Task> select(UUID taskId);

    Flux<Task> selectAll();
}

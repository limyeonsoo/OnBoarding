package com.example.webfluxonboarding.controller;

import com.example.webfluxonboarding.todos.tasks.Task;
import com.example.webfluxonboarding.todos.tasks.TaskAttributesInsert;
import com.example.webfluxonboarding.todos.tasks.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping("/tasks")
record TaskController(
        TaskService taskService
) {
    TaskController {
        Objects.requireNonNull(taskService);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Mono<TaskIdResponse> create(final TaskCreateRequest request) {
        return taskService.insert(toTaskAttributesInsert(request))
                .map(TaskController::toTaskIdResponse);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Flux<TaskResponse> retrieveAll() {
        return taskService.selectAll()
                .map(TaskController::toTaskResponse);
    }

    private static TaskAttributesInsert toTaskAttributesInsert(final TaskCreateRequest request) {
        return new TaskAttributesInsert(request.details());
    }

    private static TaskResponse toTaskResponse(final Task task) {
        return new TaskResponse(
                task.taskId().toString(),
                task.details(),
                task.taskStatus().name()
        );
    }

    private static TaskIdResponse toTaskIdResponse(final Task task) {
        return new TaskIdResponse(task.taskId().toString());
    }
}

package com.sds.mvcOnboarding.controller;

import com.sds.mvcOnboarding.domain.Task;
import com.sds.mvcOnboarding.service.TodoCreateAttributes;
import com.sds.mvcOnboarding.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
class TodoController {

    private final TodoService todoService;

    TodoController(final TodoService todoService) {
        this.todoService = Objects.requireNonNull(todoService);
    }

    @PostMapping
    TaskIdResponse create(@RequestBody final TaskCreateRequest request) {
        final var todoCreateAttributes = new TodoCreateAttributes(
                request.member_id(),
                request.content()
        );
        final var identifier = todoService.create(todoCreateAttributes);
        return toTaskIdResponse(identifier);
    }

    @GetMapping("/{id}")
    TaskResponse retrieve(@PathVariable final int id) {
        final var task = todoService.retrieve(id);
        return toResponse(task);
    }

    @GetMapping
    List<TaskResponse> retrieveAll() {
        final var taskList = todoService.retrieveAll();
        return taskList.stream()
                .map(TodoController::toResponse)
                .collect(Collectors.toList());
    }

    static TaskIdResponse toTaskIdResponse(final int id) {
        return new TaskIdResponse(id);
    }

    static TaskResponse toResponse(final Task task) {
        return new TaskResponse(
                task.getId(),
                task.getMember_id(),
                task.getContent(),
                task.getStatus(),
                task.getCreate_date(),
                task.getModify_date()
        );
    }
}

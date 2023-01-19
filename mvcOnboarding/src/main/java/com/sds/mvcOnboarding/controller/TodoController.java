package com.sds.mvcOnboarding.controller;

import com.sds.mvcOnboarding.domain.Task;
import com.sds.mvcOnboarding.service.TodoCreateAttributes;
import com.sds.mvcOnboarding.service.TodoModifyAttributes;
import com.sds.mvcOnboarding.service.TodoService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    TaskIdResponse create(@RequestBody final TaskCreateRequest request) {
        final var todoCreateAttributes = new TodoCreateAttributes(
                request.member_id(),
                request.content()
        );
        final var identifier = todoService.create(todoCreateAttributes);
        return toTaskIdResponse(identifier);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TaskResponse retrieve(@PathVariable final int id) {
        final var task = todoService.retrieve(id);
        return toResponse(task);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<TaskResponse> retrieveAll() {
        final var taskList = todoService.retrieveAll();
        return taskList.stream()
                .map(TodoController::toResponse)
                .collect(Collectors.toList());
    }

    @PatchMapping("/{id}")
    TaskResponse modify(
            @PathVariable final int id,
            @RequestBody final TaskModifyRequest request) {
        final var modifiedTask = todoService.modify(fromIdAndRequest(id, request));
        return toResponse(modifiedTask);
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

    static TodoModifyAttributes fromIdAndRequest(
            final int id, final TaskModifyRequest request) {
        return new TodoModifyAttributes(
                id,
                request.getContent(),
                request.getStatus()
        );
    }
}

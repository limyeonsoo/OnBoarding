package com.sds.mvcOnboarding.controller;

import com.sds.mvcOnboarding.service.TodoCreateAttributes;
import com.sds.mvcOnboarding.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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

    static TaskIdResponse toTaskIdResponse(final int id) {
        return new TaskIdResponse(id);
    }
}

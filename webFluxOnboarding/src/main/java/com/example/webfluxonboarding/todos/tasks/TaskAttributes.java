package com.example.webfluxonboarding.todos.tasks;

public record TaskAttributes(
        String details,
        TaskStatus taskStatus
) {
}

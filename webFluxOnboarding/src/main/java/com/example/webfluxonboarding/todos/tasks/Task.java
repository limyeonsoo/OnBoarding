package com.example.webfluxonboarding.todos.tasks;

import java.util.UUID;

public record Task(
        UUID taskId,
        String details,
        TaskStatus taskStatus) {
}

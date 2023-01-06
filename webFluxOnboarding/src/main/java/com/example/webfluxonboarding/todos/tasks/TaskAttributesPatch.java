package com.example.webfluxonboarding.todos.tasks;

import org.springframework.lang.Nullable;

public record TaskAttributesPatch(
        @Nullable String details,
        @Nullable TaskStatus taskStatus
) {
}

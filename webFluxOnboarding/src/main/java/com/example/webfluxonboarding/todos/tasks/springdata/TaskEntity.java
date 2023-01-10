package com.example.webfluxonboarding.todos.tasks.springdata;

import com.example.webfluxonboarding.todos.tasks.TaskStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table("TASKS")
record TaskEntity(
        @Id UUID id,
        String details,
        TaskStatus taskStatus
) {
    TaskEntity {
        Objects.requireNonNull(id);
        Objects.requireNonNull(details);
        Objects.requireNonNull(taskStatus);
    }
}

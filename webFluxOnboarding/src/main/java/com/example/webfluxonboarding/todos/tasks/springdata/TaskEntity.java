package com.example.webfluxonboarding.todos.tasks.springdata;

import com.example.webfluxonboarding.todos.tasks.TaskStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("TASKS")
record TaskEntity(
        @Id UUID taskUuid,
        String details,
        TaskStatus taskStatus
) {
}

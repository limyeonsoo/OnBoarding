package com.example.webfluxonboarding.todos.tasks.springdata;

import com.example.webfluxonboarding.todos.tasks.TaskStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table("TASKS")
record TaskEntity(
        @Id UUID id,
        String details,
        TaskStatus taskStatus,
        @Transient boolean isNewTask
) implements Persistable<UUID> {
    TaskEntity {
        Objects.requireNonNull(id);
        Objects.requireNonNull(details);
        Objects.requireNonNull(taskStatus);
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    @Transient
    public boolean isNew() {
        return this.isNewTask;
    }
}

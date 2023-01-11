package com.example.webfluxonboarding.todos.tasks.springdata;

import com.example.webfluxonboarding.todos.tasks.TaskStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table("TASKS")
class TaskEntity implements Persistable<UUID> {
    @Id
    UUID id;

    String details;
    TaskStatus taskStatus;
    @Transient
    boolean isNewTask;

    protected TaskEntity() {
    }

    TaskEntity(
            final UUID id,
            final String details,
            final TaskStatus taskStatus,
            final boolean isNewTask) {
        this.id = Objects.requireNonNull(id);
        this.details = Objects.requireNonNull(details);
        this.taskStatus = Objects.requireNonNull(taskStatus);
        this.isNewTask = isNewTask;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    @Override
    @Transient
    public boolean isNew() {
        return this.isNewTask;
    }
}

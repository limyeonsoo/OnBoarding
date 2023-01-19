package com.sds.mvcOnboarding.service;

import org.springframework.lang.Nullable;

import java.util.Objects;

public class TodoModifyAttributes {
    private final int id;
    private final String content;
    private final String status;

    public TodoModifyAttributes(
            final int id,
            @Nullable final String content,
            @Nullable final String status) {
        this.id = Objects.requireNonNull(id);
        this.content = content;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }
}

package com.sds.mvcOnboarding.controller;

import java.util.Objects;

class TaskCreateRequest {
    final int member_id;
    private final String content;

    public TaskCreateRequest(
            final int member_id,
            final String content) {
        this.member_id = Objects.requireNonNull(member_id);
        this.content = Objects.requireNonNull(content);
    }

    int member_id() {
        return this.member_id;
    }

    String content() {
        return this.content;
    }
}

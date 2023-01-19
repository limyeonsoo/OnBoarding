package com.sds.mvcOnboarding.controller;

import org.springframework.lang.Nullable;

class TaskModifyRequest {
    private final String content;
    private final String status;

    TaskModifyRequest(
            @Nullable final String content,
            @Nullable final  String status) {
        this.content = content;
        this.status = status;
    }

    String getContent() {
        return content;
    }

    String getStatus() {
        return status;
    }
}

package com.sds.mvcOnboarding.controller;

import java.util.Objects;

class TaskResponse {
    private final int id;
    private final int member_id;
    private final String content;
    private final String status;
    private final long create_date;
    private final long modify_date;

    public TaskResponse(
            final int id,
            final int member_id,
            final String content,
            final String status,
            final long create_date,
            final long modify_date
    ) {
        this.id = id;
        this.member_id = member_id;
        this.content = Objects.requireNonNull(content);
        this.status = Objects.requireNonNull(status);
        this.create_date = create_date;
        this.modify_date = modify_date;
    }
}

package com.sds.mvcOnboarding.domain;

import java.util.Objects;

public class Task {
    private final int id;
    private final int member_id;
    private final String content;
    private final TaskStatus status;
    private final long create_date;
    private final long modify_date;

    public Task(
            int id,
            int member_id,
            String content,
            TaskStatus status,
            long create_date,
            long modify_date
    ) {
        this.id = id;
        this.member_id = member_id;
        this.content = Objects.requireNonNull(content);
        this.status = Objects.requireNonNull(status);
        this.create_date = create_date;
        this.modify_date = modify_date;
    }

    public int getId() {
        return id;
    }

    public int getMember_id() {
        return member_id;
    }

    public String getContent() {
        return content;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public long getCreate_date() {
        return create_date;
    }

    public long getModify_date() {
        return modify_date;
    }
}

package com.sds.mvcOnboarding.service;

import java.util.Objects;

public class TodoCreateAttributes {
    private final int member_id;
    private final String content;

    public TodoCreateAttributes(
            final int member_id,
            final String content) {
        this.member_id = member_id;
        this.content = Objects.requireNonNull(content);
    }

    public int getMember_id() {
        return member_id;
    }

    public String getContent() {
        return content;
    }
}

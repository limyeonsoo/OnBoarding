package com.sds.mvcOnboarding.controller;

class TaskIdResponse {
    private final int id;

    TaskIdResponse(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

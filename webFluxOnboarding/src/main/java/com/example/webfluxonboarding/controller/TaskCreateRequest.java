package com.example.webfluxonboarding.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

record TaskCreateRequest(
        @JsonProperty(value = "details", required = true) String details
) {
    TaskCreateRequest {
        Objects.requireNonNull(details);
    }
}

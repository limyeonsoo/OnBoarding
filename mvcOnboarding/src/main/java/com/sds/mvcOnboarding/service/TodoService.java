package com.sds.mvcOnboarding.service;

import com.sds.mvcOnboarding.domain.Task;

import java.util.List;

public interface TodoService {
    int create(TodoCreateAttributes attributes);

    Task retrieve(int id);

    List<Task> retrieveAll();
}

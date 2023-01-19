package com.sds.mvcOnboarding.repository.springData;

import com.sds.mvcOnboarding.domain.Task;
import com.sds.mvcOnboarding.service.TodoCreateAttributes;
import com.sds.mvcOnboarding.service.TodoModifyAttributes;
import com.sds.mvcOnboarding.service.TodoService;

import java.util.List;

public class TodoSpringDataService implements TodoService {

    @Override
    public int create(final TodoCreateAttributes attributes) {
        throw new RuntimeException("not implement");
    }

    @Override
    public Task retrieve(final int id) {
        throw new RuntimeException("not implement");
    }

    @Override
    public List<Task> retrieveAll() {
        throw new RuntimeException("not implement");
    }

    @Override
    public Task modify(final TodoModifyAttributes attributes) {
        throw new RuntimeException("not implement");
    }

    @Override
    public void delete(final int id) {
        throw new RuntimeException("not implement");
    }
}

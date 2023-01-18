package com.sds.mvcOnboarding.repository.springData;

import com.sds.mvcOnboarding.service.TodoCreateAttributes;
import com.sds.mvcOnboarding.service.TodoService;

public class TodoSpringDataService implements TodoService {

    @Override
    public int create(TodoCreateAttributes attributes) {
        throw new RuntimeException("not implement");
    }
}

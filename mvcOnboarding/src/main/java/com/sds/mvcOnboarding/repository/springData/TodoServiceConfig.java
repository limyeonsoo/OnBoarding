package com.sds.mvcOnboarding.repository.springData;

import com.sds.mvcOnboarding.repository.TaskRepository;
import com.sds.mvcOnboarding.repository.springData.TodoSpringDataService;
import com.sds.mvcOnboarding.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TodoServiceConfig {

    @Bean
    TodoService todoService(final TaskRepository taskRepository) {
        return new TodoSpringDataService(taskRepository);
    }
}

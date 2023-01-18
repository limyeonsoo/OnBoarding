package com.sds.mvcOnboarding.service;

import com.sds.mvcOnboarding.repository.springData.TodoSpringDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TodoServiceConfig {

    @Bean
    TodoService todoService() {
        return new TodoSpringDataService();
    }
}

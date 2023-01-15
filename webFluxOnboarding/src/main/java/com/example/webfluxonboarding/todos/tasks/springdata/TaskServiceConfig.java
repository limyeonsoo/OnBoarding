package com.example.webfluxonboarding.todos.tasks.springdata;

import com.example.webfluxonboarding.todos.tasks.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
class TaskServiceConfig {

    @Bean
    TaskService taskService(
            final TaskSpringDataRepository taskSpringDataRepository
    ) {
        return new TaskSpringDataService(
                taskSpringDataRepository,
                UUID::randomUUID
        );
    }
}

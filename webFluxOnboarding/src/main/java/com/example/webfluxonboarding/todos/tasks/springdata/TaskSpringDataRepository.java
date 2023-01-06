package com.example.webfluxonboarding.todos.tasks.springdata;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TaskSpringDataRepository extends ReactiveCrudRepository<TaskEntity, Long> {
}

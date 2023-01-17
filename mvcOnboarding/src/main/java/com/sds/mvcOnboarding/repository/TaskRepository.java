package com.sds.mvcOnboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}

package com.labworks.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.labworks.projectmanager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

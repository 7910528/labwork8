package com.labworks.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.labworks.projectmanager.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

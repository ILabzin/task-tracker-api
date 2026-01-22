package org.labzin.task.tracker.repository;

import org.labzin.task.tracker.model.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}

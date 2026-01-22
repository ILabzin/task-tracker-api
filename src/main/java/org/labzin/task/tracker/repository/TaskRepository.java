package org.labzin.task.tracker.repository;

import org.labzin.task.tracker.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}

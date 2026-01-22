package org.labzin.task.tracker.repository;

import org.labzin.task.tracker.model.TaskStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStateRepository extends JpaRepository<TaskStateEntity, Long> {
}

package org.labzin.task.tracker.factories;

import org.labzin.task.tracker.dto.TaskDto;
import org.labzin.task.tracker.model.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoFactory {

    public TaskDto makeTaskDto (TaskEntity entity) {

        return TaskDto.builder().
                id(entity.getId()).
                name(entity.getName()).
                description(entity.getDescription()).
                createdAt(entity.getCreatedAt()).
                build();
    }
}

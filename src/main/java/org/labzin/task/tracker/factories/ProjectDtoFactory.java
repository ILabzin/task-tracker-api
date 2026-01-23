package org.labzin.task.tracker.factories;

import org.labzin.task.tracker.dto.ProjectDto;
import org.labzin.task.tracker.model.ProjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoFactory {

    public ProjectDto makeProjectDto(ProjectEntity entity) {

        return ProjectDto.builder().
                id(entity.getId()).
                name(entity.getName()).
                createdAt(entity.getCreatedAt()).build();
    }
}

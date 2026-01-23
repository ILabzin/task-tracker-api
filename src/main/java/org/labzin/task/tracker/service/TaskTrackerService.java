package org.labzin.task.tracker.service;

import lombok.AllArgsConstructor;
import org.labzin.task.tracker.dto.ProjectDto;
import org.labzin.task.tracker.exceptions.BadRequestException;
import org.labzin.task.tracker.exceptions.NotFoundException;
import org.labzin.task.tracker.factories.ProjectDtoFactory;
import org.labzin.task.tracker.model.ProjectEntity;
import org.labzin.task.tracker.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TaskTrackerService {

    private final ProjectRepository projectRepository;
    private final ProjectDtoFactory projectDtoFactory;

    @Transactional
    public ProjectDto createProject(String name) {

        if(projectRepository.findByName(name).isPresent()) {
            throw new BadRequestException(String.format("Project \"%s\" already exist", name));
        }

        ProjectEntity project = ProjectEntity.builder().name(name).build();
        projectRepository.save(project);

    return projectDtoFactory.makeProjectDto(project);
    }

    public ProjectDto editProject(Long projectId, String name) {

        if(name.trim().isEmpty()) {
            throw new BadRequestException(String.format("\"%s\" can not be empty", name));
        }

        ProjectEntity project = projectRepository.findById(projectId)
                .orElseThrow(() -> new NotFoundException(String.format("Project \"%s\" not found", name)));

        projectRepository.findByName(name).filter(anotherProject -> !anotherProject.getId().equals(projectId))
                .ifPresent(anotherProject -> {
                    throw new BadRequestException(String.format("\"%s\" duplicate", name));
                });

        return projectDtoFactory.makeProjectDto(project);
    }
}

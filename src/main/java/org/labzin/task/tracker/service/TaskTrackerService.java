package org.labzin.task.tracker.service;

import lombok.AllArgsConstructor;
import org.labzin.task.tracker.dto.ProjectDto;
import org.labzin.task.tracker.exceptions.BadRequestException;
import org.labzin.task.tracker.model.ProjectEntity;
import org.labzin.task.tracker.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TaskTrackerService {

    private final ProjectRepository projectRepository;

    @Transactional
    public ProjectDto createProject(String name) {

        if(projectRepository.findByName(name).isPresent()) {
            throw new BadRequestException(String.format("Проект с названием \"%s\" уже есть", name));
        }

        throw new BadRequestException(String.format("Project \"%s\" already exist", name));

        //projectRepository.save(ProjectEntity.builder().name(name).build());

    //return null;
    }
}

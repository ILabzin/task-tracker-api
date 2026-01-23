package org.labzin.task.tracker.controllers;

import lombok.RequiredArgsConstructor;
import org.labzin.task.tracker.dto.ProjectDto;
import org.labzin.task.tracker.factories.ProjectDtoFactory;
import org.labzin.task.tracker.factories.TaskDtoFactory;
import org.labzin.task.tracker.factories.TaskStateDtoFactory;
import org.labzin.task.tracker.repository.ProjectRepository;
import org.labzin.task.tracker.service.TaskTrackerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    public final TaskTrackerService taskTrackerService;

    public static final String CREATE_PROJECT = "/api/projects";

    @PostMapping(CREATE_PROJECT)
    public ProjectDto createProject(@RequestParam String name) {

      return taskTrackerService.createProject(name);
    }

}

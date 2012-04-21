package ru.deeper4k.space.controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.deeper4k.space.entity.Project;
import ru.deeper4k.space.service.ProjectsService;

import java.util.List;

/**
 * Projects controller
 *
 * @author Albert Gazizov
 */
@Controller
@RequestMapping("/api/projects")
public class ProjectsController {

    @Autowired
    private ProjectsService _projectsService;

    /** Logger */
    private final Logger _logger = LoggerFactory.getLogger(ProjectsController.class);

    /**
     * Get all projects
     * @return projects
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json") @ResponseBody
    public List<Project> findAll() {
        // TODO rewrite
        Long currentUserId = 1L;
        return _projectsService.getProjectsByUserId(currentUserId);
    }

    /**
     * Get a project by id
     * @param aId the aProject id
     * @return a project
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET) @ResponseBody
    public final Project get( @PathVariable( "id" ) final Long aId){
        return _projectsService.getProjectById(aId);
    }

    /**
     * Create a project
     * @param aProject the project to save
     * @return the saved project
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json") @ResponseStatus(HttpStatus.CREATED) @ResponseBody
    public Project create(@RequestBody Project aProject) {
        Assert.notNull(aProject);
        Project project = _projectsService.createProject(aProject);
        return project;
    }

    /**
     * Update a given project fields
     * @param aProject the story to update
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT) @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Project aProject, @PathVariable("id") Long aId) {
        Assert.isTrue(aProject.getId().equals(aId));
        _projectsService.updateProject(aProject);
    }

    /**
     * Remove project with the specified id
     * @param aId the project id
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE) @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable( "id" ) final Long aId) {
        _projectsService.removeProject(aId);
    }

}
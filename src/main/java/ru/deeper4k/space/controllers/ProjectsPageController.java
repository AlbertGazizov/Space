package ru.deeper4k.space.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.deeper4k.space.entity.Project;
import ru.deeper4k.space.service.ProjectsService;

/**
 * Projects controller
 *
 * @author Albert Gazizov
 */
@Controller
@RequestMapping("/projects")
public class ProjectsPageController {

    @Autowired
    private ProjectsService _projectsService;

    /** Logger */
    private final Logger _logger = LoggerFactory.getLogger(ProjectsPageController.class);
//
//    /**
//     * Get all projects
//     * @return projects
//     */
//    @ModelAttribute("projects")
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Project> findAll() {
//        // TODO rewrite
//        Long currentUserId = 1L;
//        return _projectsService.getProjectsByUserId(currentUserId);
//    }

    /**
     * Get a project by id
     * @param aId the aProject id
     * @return a project
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView get( @PathVariable( "id" ) final Long aId) {
        Project project = _projectsService.getProjectById(aId);
        ModelAndView mav = new ModelAndView("project");
        mav.addObject("project", project);
        return mav;
    }

}

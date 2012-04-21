package ru.deeper4k.space.controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.deeper4k.space.entity.Story;
import ru.deeper4k.space.service.ProjectsService;

import java.util.List;


/**
 * Stories controller
 *
 * @author Albert Gazizov
 */

@Controller
@RequestMapping("/api/stories")
public class StoriesController {

    @Autowired
    private ProjectsService _projectsService;

    /** Logger */
    private final Logger _logger = LoggerFactory.getLogger(StoriesController.class);

    /**
     * Get all stories
     * @return stories
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json") @ResponseBody
    public List<Story> findAll() {
        return _projectsService.getStories();
    }

    /**
     * Get a story by id
     * @param aId the aStory id
     * @return a story
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET) @ResponseBody
    public final Story get( @PathVariable( "id" ) final Long aId){
        return _projectsService.getStoryById(aId);
    }

    /**
     * Create a story
     * @param aStory the story to save
     * @return the saved story
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json") @ResponseStatus(HttpStatus.CREATED) @ResponseBody
    public Story create(@RequestBody Story aStory) {
        Assert.notNull(aStory);
        Story story = _projectsService.createStory(aStory);
        return story;
    }

    /**
     * Update a given story fields
     * @param aStory the story to update
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT) @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Story aStory, @PathVariable("id") Long aId) {
        Assert.isTrue(aStory.getId().equals(aId));
        _projectsService.updateStory(aStory);
    }

    /**
     * Remove story with the specified id
     * @param aId the story id
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE) @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable( "id" ) final Long aId) {
        _projectsService.removeStory(aId);
    }

}
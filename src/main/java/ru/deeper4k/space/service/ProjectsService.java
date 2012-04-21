package ru.deeper4k.space.service;

import ru.deeper4k.space.entity.Project;
import ru.deeper4k.space.entity.Story;

import java.util.List;

/**
 * Stories service interface
 *
 * @author Albert Gazizov
 */
public interface ProjectsService {

    /**
     * Get all projects
     * @return projects
     */
    public List<Project> getProjects();

    /**
     * Get a project by id
     * @param aId the project id
     * @return a story
     */
    public Project getProjectById(Long aId);

    /**
     * Saves project
     * @param aProject the project to save
     * @return the saved project
     */
    public Project createProject(Project aProject);

    /**
     * Update a given project
     * @param aProject the project to update
     */
    public void updateProject(Project aProject);

    /**
     * Remove project with the specified id
     * @param aId the project id
     */
    public void removeProject(Long aId);

    /**
     * Get all stories
     * @return stories
     */
    public List<Story> getStories();

    /**
     * Get a story by id
     * @param aId the story id
     * @return a story
     */
    public Story getStoryById(Long aId);

    /**
     * Saves story
     * @param aStory the story to save
     * @return the saved story
     */
    public Story createStory(Story aStory);

    /**
     * Update a given story from db
     * @param aStory the story to update
     */
    public void updateStory(Story aStory);

    /**
     * Remove story with the specified id
     * @param aId the story id
     */
    public void removeStory(Long aId);

}

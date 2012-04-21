package ru.deeper4k.space.dao;

import ru.deeper4k.space.entity.Project;
import ru.deeper4k.space.entity.Story;

import java.util.List;

/**
 * Projects data access interface
 *
 * @author Albert Gazizov
 */
public interface ProjectDao {

    /**
     * Get all projects
     * @return stories
     */
    List<Project> getAll();

    /**
     * Get a project by id
     * @param aId the story id
     * @return a story
     */
    public Project getById(Long aId);

    /**
     * Saves project
     * @param aStory the project to save
     * @return the saved project
     */
    public Project create(Project aStory);

    /**
     * Update a given project from db
     * @param aStory the project to update
     */
    public void update(Project aStory);

    /**
     * Remove project with the specified id
     * @param aId the project id
     */
    public void remove(Long aId);

    /**
     * Remove a project
     * @param aProject the project
     */
    public void remove(Project aProject);

}

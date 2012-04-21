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
     * @return projects
     */
    List<Project> getAll();

    /**
     * Get a project by id
     * @param aId the story id
     * @return a project
     */
    public Project getById(Long aId);

    /**
     * Get a project by owner identifier
     * @param aOwnerId the owner user id
     * @return a project
     */
    public List<Project> getByOwnerId(Long aOwnerId);

    /**
     * Saves project
     * @param aProject the project to save
     * @return the saved project
     */
    public Project create(Project aProject);

    /**
     * Update a given project from db
     * @param aProject the project to update
     */
    public void update(Project aProject);

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

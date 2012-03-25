package ru.deeper4k.space.dao;

import ru.deeper4k.space.entity.Story;

import java.util.List;

/**
 * Stories data access interface
 *
 * @author Albert Gazizov
 */
public interface StoryDao {

    /**
     * Get all stories
     * @return stories
     */
    List<Story> findAll();

    /**
     * Get a story by id
     * @param aId the story id
     * @return a story
     */
    public Story findById(Long aId);

    /**
     * Saves story
     * @param aStory the story to save
     * @return the saved story
     */
    public Story create(Story aStory);

    /**
     * Update a given story from db
     * @param aStory the story to update
     */
    public void update(Story aStory);

    /**
     * Remove story with the specified id
     * @param aId the story id
     */
    public void remove(Long aId);

}

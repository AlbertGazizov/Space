package ru.deeper4k.space.dao;

import ru.deeper4k.space.entity.User;

import java.util.List;

/**
 * Users data access interface
 *
 * @author Albert Gazizov
 */
public interface UserDao {

    /**
     * Get all users
     * @return users
     */
    List<User> getAll();

    /**
     * Get a user by id
     * @param aId the story id
     * @return a user
     */
    public User getById(Long aId);

    /**
     * Saves user
     * @param aUser the user to save
     * @return the saved user
     */
    public User create(User aUser);

    /**
     * Update a given user from db
     * @param aUser the user to update
     */
    public void update(User aUser);

    /**
     * Remove user with the specified id
     * @param aId the user id
     */
    public void remove(Long aId);

    /**
     * Remove a user
     * @param aUser the user
     */
    public void remove(User aUser);

}

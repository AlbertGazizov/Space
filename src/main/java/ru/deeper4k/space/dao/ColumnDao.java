package ru.deeper4k.space.dao;

import ru.deeper4k.space.entity.Column;

import java.util.List;

/**
 * Columns data access interface
 *
 * @author Albert Gazizov
 */
public interface ColumnDao {

    /**
     * Get all columns
     * @return columns
     */
    List<Column> getAll();

    /**
     * Get a column by id
     * @param aId the story id
     * @return a column
     */
    public Column getById(Long aId);

    /**
     * Get columns by project identifier
     * @param aProjectId the project id
     * @return a column
     */
    public List<Column> getByProjectId(Long aProjectId);

    /**
     * Saves column
     * @param aColumn the column to save
     * @return the saved column
     */
    public Column create(Column aColumn);

    /**
     * Update a given column from db
     * @param aColumn the column to update
     */
    public void update(Column aColumn);

    /**
     * Remove column with the specified id
     * @param aId the column id
     */
    public void remove(Long aId);

    /**
     * Remove a column
     * @param aColumn the column
     */
    public void remove(Column aColumn);

}

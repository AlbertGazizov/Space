package ru.deeper4k.space.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Story entity
 *
 * @author Albert Gazizov
 */
@Entity
@Table(name = "stories")
public class Story extends BaseEntity implements Comparable<Story> {

    /** Title */
    private String _title;

    /** Description */
    private String _description;

    /** The user that created a story */
    private User _owner;

    /** The user that wil work on a story */
    private User _developer;

    /** Story column */
    private Column _column;
    
    private Integer _position = 0;

    /**
     * Get the {@link #_title title} field value
     * @return the field value
     */
    public String getTitle() {
        return _title;
    }

    /**
     * Set the {@link #_title title} field value
     * @param aTitle the value to set
     */
    public void setTitle(String aTitle) {
        _title = aTitle;
    }

    /**
     * Get the {@link #_description description} field value
     * @return the field value
     */
    public String getDescription() {
        return _description;
    }

    /**
     * Set the {@link #_description description} field value
     * @param aDescription the value to set
     */
    public void setDescription(String aDescription) {
        _description = aDescription;
    }

    /**
     * Get the {@link #_owner owner} field value
     * @return the field value
     */
    @ManyToOne(optional = false)
    public User getOwner() {
        return _owner;
    }

    /**
     * Set the {@link #_owner owner} field value
     * @param aOwner the value to set
     */
    public void setOwner(User aOwner) {
        _owner = aOwner;
    }

    /**
     * Get the {@link #_developer developer} field value
     * @return the field value
     */
    @ManyToOne
    public User getDeveloper() {
        return _developer;
    }

    /**
     * Set the {@link #_developer developer} field value
     * @param aDeveloper the value to set
     */
    public void setDeveloper(User aDeveloper) {
        _developer = aDeveloper;
    }

    /**
     * Get the {@link #_column _column} field value
     * @return the field value
     */
    @ManyToOne(optional = false)
    public Column getColumn() {
        return _column;
    }

    /**
     * Set the {@link #_column _column} field value
     * @param aColumn the value to set
     */
    public void setColumn(Column aColumn) {
        _column = aColumn;
    }

    /**
     * Get the {@link #_position order} field value
     * @return the field value
     */
    public Integer getPosition() {
        return _position;
    }

    /**
     * Set the {@link #_position order} field value
     * @param aPosition the value to set
     */
    public void setPosition(Integer aPosition) {
        _position = aPosition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Story aStory) {
        return getPosition().compareTo(aStory.getPosition());
    }
}

package ru.deeper4k.space.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Column entity
 *
 * @author Albert Gazizov
 */
@Entity
@Table(name = "columns")
public class Column extends BaseEntity implements Comparable<Column>{

    /** Column name */
    private String _name;

    /** Project */
    private Project _project;

    /** Order */
    private Integer _position = 0;
    
    private List<Story> _stories;

    /**
     * Get the {@link #_name name} field value
     * @return the field value
     */
    public String getName() {
        return _name;
    }

    /**
     * Set the {@link #_name name} field value
     * @param aName the value to set
     */
    public void setName(String aName) {
        _name = aName;
    }

    /**
     * Get the {@link #_project project} field value
     * @return the field value
     */
    @ManyToOne(optional = false)
    public Project getProject() {
        return _project;
    }

    /**
     * Set the {@link #_project project} field value
     * @param aProject the value to set
     */
    public void setProject(Project aProject) {
        _project = aProject;
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
     * Get the {@link #_stories stories} field value
     * @return the field value
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "column")
    public List<Story> getStories() {
        return _stories;
    }

    /**
     * Set the {@link #_stories stories} field value
     * @param aStories the value to set
     */
    public void setStories(List<Story> aStories) {
        _stories = aStories;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Column aColumn) {
        return getPosition().compareTo(aColumn.getPosition());
    }
}

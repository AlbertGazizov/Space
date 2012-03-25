package ru.deeper4k.space.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Story entity
 *
 * @author Albert Gazizov
 */
@Entity
@Table(name = "stories")
public class Story extends BaseEntity {

    /** Title */
    private String _title;

    /** Description */
    private String _description;

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

}

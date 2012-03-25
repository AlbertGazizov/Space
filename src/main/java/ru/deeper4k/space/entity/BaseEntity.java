package ru.deeper4k.space.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base Entity declares the basic field for project entities
 *
 * @author Albert Gazizov
 */
@MappedSuperclass
public class BaseEntity {

    /** Entity's unique identifier */
    private Long _id;

    /**
     * Get the {@link #_id id} field value
     * @return the field value
     */
    @Id
    @GeneratedValue
    public Long getId() {
        return _id;
    }

    /**
     * Set the {@link #_id id} field value
     * @param aId the value to set
     */
    public void setId(Long aId) {
        _id = aId;
    }

}

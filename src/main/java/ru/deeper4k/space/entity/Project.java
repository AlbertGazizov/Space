package ru.deeper4k.space.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Project entity
 *
 * @author Albert Gazizov
 */
@Entity
@Table(name = "projects")
public class Project extends BaseEntity {

    /** Project name */
    private String _name;

    /** Project owner */
    private User _owner;

    /* Project members */
    private List<User> _members;

    /** Columns */
    private List<Column> _columns;

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
        this._owner = aOwner;
    }

    /**
     * Get the {@link #_members members} field value
     * @return the field value
     */
    @ManyToMany(mappedBy = "projects")
    public List<User> getMembers() {
        return _members;
    }

    /**
     * Set the {@link #_members members} field value
     * @param aMembers the value to set
     */
    public void setMembers(List<User> aMembers) {
        _members = aMembers;
    }

    /**
     * Get the {@link #_columns columns} field value
     * @return the field value
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy="project")
    public List<Column> getColumns() {
        return _columns;
    }

    /**
     * Set the {@link #_columns columns} field value
     * @param aColumns the value to set
     */
    public void setColumns(List<Column> aColumns) {
        _columns = aColumns;
    }

}

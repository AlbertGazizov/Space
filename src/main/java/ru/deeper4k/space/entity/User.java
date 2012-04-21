package ru.deeper4k.space.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * User entity
 *
 * @author Albert Gazizov
 */
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    /** Email */
    private String _email;

    /** Password */
    private String _password;

    /** First name */
    private String _firstName;

    /** Last name */
    private String _lastName;

    /** User projects */
    private List<Project> _projects;

    /**
     * Get the {@link #_email email} field value
     * @return the field value
     */
    public String getEmail() {
        return _email;
    }

    /**
     * Set the {@link #_email email} field value
     * @param aEmail the value to set
     */
    public void setEmail(String aEmail) {
        _email = aEmail;
    }

    /**
     * Get the {@link #_password password} field value
     * @return the field value
     */
    public String getPassword() {
        return _password;
    }

    /**
     * Set the {@link #_password password} field value
     * @param aPassword the value to set
     */
    public void setPassword(String aPassword) {
        _password = aPassword;
    }

    /**
     * Get the {@link #_firstName firstName} field value
     * @return the field value
     */
    public String getFirstName() {
        return _firstName;
    }

    /**
     * Set the {@link #_firstName firstName} field value
     * @param aFirstName the value to set
     */
    public void setFirstName(String aFirstName) {
        _firstName = aFirstName;
    }

    /**
     * Get the {@link #_lastName lastName} field value
     * @return the field value
     */
    public String getLastName() {
        return _lastName;
    }
    /**
     * Set the {@link #_lastName lastName} field value
     * @param aLastName the value to set
     */
    public void setLastName(String aLastName) {
        _lastName = aLastName;
    }

    /**
     * Get the {@link #_projects projects} field value
     * @return the field value
     */
    @ManyToMany
    public List<Project> getProjects() {
        return _projects;
    }

    /**
     * Set the {@link #_projects projects} field value
     * @param aProject the value to set
     */
    public void setProjects(List<Project> aProject) {
        _projects = aProject;
    }

}

package ru.deeper4k.space.entity;

/**
 * Created by IntelliJ IDEA.
 * User: albert
 * Date: 4/21/12
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class User extends BaseEntity {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

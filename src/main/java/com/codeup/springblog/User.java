package com.codeup.springblog;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    //id BIGINT NOT NULL AUTO_INCREMENT
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 20, unique = true)
    @NotBlank(message = "Username can't be empty")
    private String username;

    @Column(nullable = false, unique = true)
    @Email(message = "Invalid email")
    @NotBlank(message = "Email can't be empty")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Password can't be empty")
    private String password;
    //firstName VARCHAR(100) NOT NULL
    @Column(name = "first_name",nullable = false, length = 100)
    private String firstName;
    //lastName VARCHAR(100) NOT NULl
    @Column(name = "last_name",nullable =false, length = 100)
    private String lastName;

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public User(){
    }

    public User(long id, String userName, String lastName, String firstName, String email, String password){
        this.id = id;
        this.username = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(String userName, String lastName, String firstName, String email, String password){
        this.username = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    public Long getUserId() {
        return id;
    }

    public void setUserId(Long user_id) {
        this.id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
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

    public String getEmail(){
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
}

package com.zuitt.wdc044.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity //mark this class as a representation of a database table
@Table(name="users") //name the table
public class User {

    @Id //indicate that this property represents the primary key of table
    @GeneratedValue //auto-increment
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore // added to avoid infinite nesting when retrieving post content
    private Set<Post> posts;

    public Set<Post> getPosts(){
        return posts;
    }

    //default constructor
    public User(){}


    //parameterized constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    //getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

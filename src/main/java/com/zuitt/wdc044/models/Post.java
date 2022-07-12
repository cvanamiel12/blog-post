package com.zuitt.wdc044.models;

import javax.persistence.*;

@Entity //mark this class as a representation of a database table
@Table(name="posts") //name the table
public class Post {

    @Id //indicate that this property represents the primary key of table
    @GeneratedValue //auto-increment
    private Long id; //Long = data type

    @Column
    private String title;

    @Column
    private String content;

    //default constructor
    public Post(){}

    //parameterized constructor
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}

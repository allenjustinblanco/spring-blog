package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table
class Post {

    //id BIGINT NOT NULL AUTO_INCREMENT
    @Id @GeneratedValue
    private int id;
    //title VARCHAR(100) NOT NULL,
    @Column(nullable = false, length=100)
    private String title;
    //body VARCHAR(255) NOT NULL
    @Column(nullable = false)
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

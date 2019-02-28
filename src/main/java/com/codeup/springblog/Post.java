package com.codeup.springblog;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name="posts")
class Post {
    //id BIGINT NOT NULL AUTO_INCREMENT
    @Id @GeneratedValue
    private long id;
    //title VARCHAR(100) NOT NULL,
    @Column(nullable = false, length=100)
    private String title;
    //body VARCHAR(255) NOT NULL
    @Column(nullable = false, length = 5000)
    private String body;
    //userId VARCHAR(255) NOT NULL
    @Column(nullable = false)
    private long userId;

    @Value("${file-upload-path}")
    private String uploadPath;

    public Post(){
    }

    public Post(long userId, String title, String body){
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    Post(String title, String body) {
        setTitle(title);
        setBody(body);
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(){
        this.userId = userId;
    }
}

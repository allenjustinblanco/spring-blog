package com.codeup.springblog;

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

    public Post(){
        setId(id);
        setBody(body);
        setTitle(title);
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
}

package com.codeup.springblog;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name="posts")
public
class Post {
    //id BIGINT NOT NULL AUTO_INCREMENT
    @Id @GeneratedValue
    private long id;
    //title VARCHAR(100) NOT NULL,
    @Column(nullable = false, length=100)
    @NotBlank(message = "Posts must have a title")
    private String title;
    //body VARCHAR(255) NOT NULL
    @Column(nullable = false, length = 5000)
    @NotBlank(message = "Posts must have a body")
    private String body;

    @Column()
    private String image;

    @OneToOne
    private User user;

    @Value("${file-upload-path}")
    private String uploadPath;

    public Post(){
    }

    public Post(Users user, String title, String body, String image){
        this.title = title;
        this.body = body;
        this.user = (User) user;
        this.image = image;
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

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}

package com.codeup.springblog;
import javax.persistence.*;
@Entity
@Table(name="post_images")
class PostImage {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String path;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


}
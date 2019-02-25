package com.codeup.springblog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
    }

    //retrieving all posts
    public List<Post> all() {
        return posts;
    }

    //finding a posts
    public Post one(long id) {
        return posts.get((int) (id - 1));
    }

}
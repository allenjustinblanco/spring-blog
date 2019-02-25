package com.codeup.springblog;

public class Post {
    private String title;
    private String body;

    String getTitle(String title) {
        return title;
    }
    void setTitle(String title){
        this.title = title;
    }
    String getBody(String body){
        return body;
    }
    void setBody(String body){
        this.body = body;
    }
}

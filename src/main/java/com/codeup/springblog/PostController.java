package com.codeup.springblog;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {

    @RequestMapping(path = "/post", method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable String posts) {
        return "posts index page";
    }


    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getId() {
        return "view an individual post";
    }


    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String getCreate() {
        return "view the form for creating a post";
    }


    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String postCreate() {
        return "create a new post";
    }
}

package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post();
        post1.setTitle("Post 1 Title");
        post1.setBody("Post 1 Body");
        posts.add(post1);
        Post post2 = new Post();
        post2.setTitle("Post 1 Title");
        post2.setBody("Post 1 Body");
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "/posts/index";
    }


    @GetMapping("/posts/{id}")
    public String getIndividualPosts(Model model) {
        Post post = new Post();
        post.setBody("body");
        post.setTitle("title");
        model.addAttribute("post", post);
        return "/posts/show";
    }


    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String getCreate() {
        return "view the form for creating a post";
    }


    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String postCreate() {
//        model.addAttribute("title", title);
//        model.addAttribute("body", body);
        return "create a new post";
    }
}

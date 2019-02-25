package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        List<Post> posts = new ArrayList<>();

        model.addAttribute("posts", posts);
        return "/posts/index";
    }


    @GetMapping("/posts/{id}")
    public String getIndividualPosts(Model model) {
        Post post = new Post();
        post.setBody("body");
        post.setTitle("title");
        model.addAttribute("postTitle", post.getBody());
        model.addAttribute("postBody", post.getTitle());
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

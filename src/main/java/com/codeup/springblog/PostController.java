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


    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreate(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        postService.save(post);
        return "redirect:/posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@RequestParam(value = "title") String title,@RequestParam(value = "body") String body ){
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        postService.save(post);
        return "/posts";
    }
}

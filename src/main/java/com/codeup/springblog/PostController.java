package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    private final PostRepository postDao;
//
//    public PostController(PostRepository postDao){
//        this.postDao = postDao;
//    }

//    @GetMapping("/posts")
//    public String index(Model model) {
//        model.addAttribute("ads", postDao.findAll());
//        return "/posts/index";
//    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        List<Post> posts = new ArrayList<>();

        model.addAttribute("posts", posts);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String getIndividualPosts(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreate(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = new Post(title, body);
        postService.save(post);
        return "redirect:/posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@RequestParam(value = "title") String title,@RequestParam(value = "body") String body ){
        Post post = new Post(title, body);
        postService.save(post);
        return "posts";
    }
}

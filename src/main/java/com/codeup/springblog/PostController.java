package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.Long.parseLong;

@Controller
public class PostController {

//    private final PostService postService;
//
//    public PostController(PostService postService) {
//        this.postService = postService;
//    }

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

//    @GetMapping("/posts")
//    public String index(Model model) {
//        model.addAttribute("ads", postDao.findAll());
//        return "/posts/index";
//    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        Iterable<Post> posts = postDao.findAll();
//        List<Post> genPost = PostService.generatePost();
        model.addAttribute("posts", posts);
//        model.addAttribute("genPost", genPost);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getIndividualPosts(@PathVariable String id, Model model) {
        Post post = postDao.findOne(parseLong(id));
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreate(@ModelAttribute Post post, @RequestParam(value = "title") String title, @RequestParam(value = "body") String body){
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model){
        Post post = postDao.findOne(parseLong(id));
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public  String postEdit(@ModelAttribute Post post, @PathVariable String id, @RequestParam(value = "title") String title, @RequestParam(value = "body") String body){
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }
}

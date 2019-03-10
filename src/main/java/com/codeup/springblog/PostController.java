package com.codeup.springblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static java.lang.Long.parseLong;

@Controller
public class PostController {
    @Value("${file-upload-path}")
    private String uploadPath;

    @Autowired
    private EmailService emailService;

    public PostController(EmailService emailService) {
        this.emailService = emailService;
    }

    @Autowired
    private PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @Autowired
    public PostController(EmailService emailService, PostRepository postDao) {
        this.emailService = emailService;
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        Iterable<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
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

    @PostMapping(value = "/posts/create")
    public String postCreate(@RequestParam(value = "title") String title, @RequestParam(value = "body") String body, @RequestParam(name = "file") MultipartFile uploadedFile, Model model) throws IOException {
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        uploadedFile.transferTo(destinationFile);
        System.out.println(filename);
        model.addAttribute("message", "File successfully uploaded!");
        Post post = new Post();
        post.setImage(filename);
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
    @PostMapping("posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postDao.delete(id);
        return "redirect:/posts";
    }
}

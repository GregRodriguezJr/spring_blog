package com.example.spring_blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String AllPosts() {
        return "index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model) {
        model.addAttribute("postId", id);
        return "show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }
}

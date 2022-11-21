package com.example.spring_blog.controllers;

import com.example.spring_blog.models.Post;
import com.example.spring_blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String AllPosts(Model model) {

        //Instantiate list to hold all Post objects
        List<Post> allPosts = postDao.findAll();

        // Add the list of Posts as a model attribute to send to the template for rendering
        model.addAttribute("allPost", allPosts);

        // Return the template
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model) {

        Post myPost = new Post(id,"Five potluck ideas", "example 1, example 2...");

        model.addAttribute("myPost", myPost);
        model.addAttribute("postId", id);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model model) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }
}

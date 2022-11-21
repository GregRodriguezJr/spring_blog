package com.example.spring_blog.controllers;

import com.example.spring_blog.models.Post;
import com.example.spring_blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String AllPosts(Model model) {

        //Instantiate list to hold all Post objects
        ArrayList <Post> allPosts = new ArrayList<>();

        // Instantiate new Post objects
        Post post1 = new Post(1, "Top Destinations", "Paris, London, Hong Kong,..." );
        Post post2 = new Post(2, "The day in the life of a dev", "code, debug, code, debug");
        Post post3 = new Post(3, "VsCode vs Intellij", "Pros and cons of both...");

        // Add objects to arraylist
        allPosts.add(post1);
        allPosts.add(post2);
        allPosts.add(post3);

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
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }
}

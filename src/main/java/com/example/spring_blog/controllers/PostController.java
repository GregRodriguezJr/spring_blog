package com.example.spring_blog.controllers;

import com.example.spring_blog.models.Post;
import com.example.spring_blog.models.User;
import com.example.spring_blog.repositories.PostRepository;
import com.example.spring_blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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
        Post singlePost = postDao.getById(id);
        model.addAttribute("post", singlePost);
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
        User user = userDao.getById(1L);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }
}

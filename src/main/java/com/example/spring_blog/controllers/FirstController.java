package com.example.spring_blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Hello world from spring";
    }

    @RequestMapping (method = RequestMethod.GET, path = "/codeup")
    @ResponseBody
    public String codeup() {
        return "Hello world from codeup";
    }
}

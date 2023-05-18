package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String blogPost(ArrayList<Post> postList, Model model){
        Post post1 = new Post();
        post1.setTitle("My hell on earth");
        post1.setBody("It was actually earth, alternate timelines an all that... and I guess technically it was the moon, but you get what I mean.");
        postList.add(post1);
        Post post2 = new Post();
        post2.setTitle("Okay so it wasn't our moon, but that doesn't matter");
        post2.setBody("The phrase my hell on the third moon of an unknown System in the Andromeda just doesn't sound as good.");
        postList.add(post2);
        model.addAttribute(postList);
        return"posts/index";
    }
    @GetMapping("/post/{id}")
    public String getBlogPost(@PathVariable String id,Model model){
        Post post = new Post();
        post.setTitle("So what if at the time it was the fourth moon");
        post.setBody("Its the third moon, now. NO I am not glossing over how a planet lost a moon that isn't relevant to the story!");
        model.addAttribute(post);
        model.addAttribute("id",id);

        return "posts/show";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreate(){
        return "View the form for creating a post";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate(){
        return "create new post";
    }
}

package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String blogPost(Model model){
        model.addAttribute("posts",postDao.findAll());
        return"posts/index";
    }
    @GetMapping("/post/{post_id}")
    public String getBlogPost(@PathVariable long post_id,Model model){
        model.addAttribute("post",postDao.findById(post_id));
        return "posts/show";
    }
    @GetMapping("/edit")
    public String editBlogPost(@RequestParam long id ,Model model){
        model.addAttribute("post",postDao.findById(id));
        return "posts/edit";
    }

    @PostMapping("/edit")
    public String postEdit(@ModelAttribute Post post){
        long id = post.getId();
        System.out.println("the id is "+id);
        post.setId(id);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String getCreate(Model model){
        model.addAttribute("Post",new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String postCreate(@ModelAttribute Post post){
        postDao.findById(post.getId());
        postDao.save(post);
        return "redirect:/posts";
    }
}

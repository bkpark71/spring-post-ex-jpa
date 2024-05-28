package com.example.ditest.controller;


import com.example.ditest.dto.PostDto;
import com.example.ditest.entity.Post;
import com.example.ditest.service.PostAPIService;
import com.example.ditest.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class PostController {
    @Autowired
    private PostService postService;

//    @Autowired
//    public PostController(PostService postService) {
//        this.postService = postService;
//    }

    @GetMapping("posts")
    //@ResponseBody
    public String viewAllPosts(Model model) {
        List<Post> allPosts = postService.getAllPosts();
        log.info("All posts : {}", allPosts);
        model.addAttribute("allPosts", allPosts);
        return "post/postView";
    }

    @GetMapping("/posts/{postId}")   // restapi에서 webmvc로 수정했으므로 model 추가하기
    public String viewPost(@PathVariable("postId") Integer postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "post/postDetail";
    }

    @GetMapping("/addPosts")
    public String addPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "post/postAdd";
    }

    @PostMapping("/addPosts")
    public String addPostProcess(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/update/{postId}")
    public String updatePost(@PathVariable("postId") Integer postId, Model model) {
        Post post1 = postService.getPost(postId);
        model.addAttribute("post", post1);
        return "post/postUpdate";
    }

    @PostMapping("/posts/update/{postId}")
    public String updatePost(@PathVariable("postId") int postId, @ModelAttribute PostDto postDto) {
        postDto.setPostId(postId);
        postService.updatePost(postDto);
        return "redirect:/posts";
    }

    @GetMapping("/posts/delete/{postId}")
    public String deletePost(@PathVariable("postId") int postId) {
        log.info("Delete post : {}", postId);
        postService.deletePost(postId);
        return "redirect:/posts";
    }
}


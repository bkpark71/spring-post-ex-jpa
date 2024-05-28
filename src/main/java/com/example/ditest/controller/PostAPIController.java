package com.example.ditest.controller;


import com.example.ditest.dto.PostAPIDto;
import com.example.ditest.entity.Post;
import com.example.ditest.service.PostAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostAPIController {
    @Autowired
    private PostAPIService postAPIService;

//    @Autowired
//    public PostController(PostService postService) {
//        this.postService = postService;
//    }

    @GetMapping("/posts")
    public List<Post> viewAllPosts() {
        List<Post> allPosts = postAPIService.getAllPosts();
        return allPosts;
    }

    @GetMapping("/posts/{postId}")
    public Post viewPost(@PathVariable int postId) {
        Post post = postAPIService.getPost(postId);
        return post;
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postAPIService.addPost(post);
    }

    @PutMapping("/posts/{postId}")
    public Post updatePost(@PathVariable int postId, @RequestBody PostAPIDto postAPIDto) {
        postAPIDto.setPostId(postId);
        Post post = postAPIService.updatePost(postAPIDto);
        return post;
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable int postId) {
        postAPIService.deletePost(postId);
    }
}


package com.example.ditest.service;

import com.example.ditest.dto.PostAPIDto;
import com.example.ditest.dto.PostDto;
import com.example.ditest.entity.Post;
import com.example.ditest.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    @Transactional
    public Post addPost(Post post) {
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Transactional
    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }

    @Transactional
    public Post updatePost(PostDto postDto) {// update 필드는 body 로 제한
        Post post = postRepository.findById(postDto.getPostId()).get();
        post.setBody(postDto.getBody());
        Post updatedPost = postRepository.save(post);
        return updatedPost;
    }


    public Post getPost(int postId) {

        return postRepository.findById(postId).get();
    }
}

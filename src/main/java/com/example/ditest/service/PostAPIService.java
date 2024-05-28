package com.example.ditest.service;

import com.example.ditest.entity.Post;
import com.example.ditest.dto.PostAPIDto;
import com.example.ditest.repository.PostRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostAPIService {
    private final PostRepository postRepository;

    public PostAPIService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

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
    public Post updatePost(PostAPIDto postAPIDto) {// update 필드는 likes 로 제한
        Post post = postRepository.findById(postAPIDto.getPostId()).get();
        post.setLikes(postAPIDto.getLikes());
        Post updatedPost = postRepository.save(post);
        return updatedPost;
    }


    public Post getPost(int postId) {

        return postRepository.findById(postId).get();
    }
}

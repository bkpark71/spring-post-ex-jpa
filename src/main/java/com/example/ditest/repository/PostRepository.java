package com.example.ditest.repository;

import com.example.ditest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    List<Post> findAll();
    Optional<Post> findById(int postId);
    void deleteById(int postId);
    //void update(Post post);
    Post save(Post post);
}

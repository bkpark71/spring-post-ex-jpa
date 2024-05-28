package com.example.ditest.repository;

import com.example.ditest.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JPAPostRepository implements PostRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Post> findAll() {
        List<Post> postList = em.createQuery("select p from Post p", Post.class).getResultList();
        return postList;
    }

    @Override
    public Optional<Post> findById(int postId) {
        return Optional.ofNullable(em.find(Post.class, postId));
    }

    @Override
    public void deleteById(int postId) {
        Post findPost = em.find(Post.class, postId);
        if(findPost != null)
            em.remove(findPost);
    }

    @Override
    public Post save(Post post) {
        em.persist(post);
        return em.find(Post.class, post.getPostId());
    }
}

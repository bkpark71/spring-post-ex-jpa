package com.example.ditest.service;

import com.example.ditest.entity.Post;
import com.example.ditest.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceTest {

    private PostRepository postRepository;

    @Autowired
    public PostServiceTest(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void 게시판_글작성_테스트() {
//        //given
//        Post post = new Post(null, "test1", "body1", 0);
//        //when
//        int newId = postRepository.insert(post);
//
//        //then
//        assertThat(newId).isEqualTo(1);
//    }
}
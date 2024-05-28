package com.example.ditest.repository;

import com.example.ditest.entity.Post;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PostRepositoryImplTest {

    static Map<Integer, Post> posts = new HashMap<>();
    static int sequence;

    @BeforeEach
    void initAll(){
        System.out.println("before each");
    }

    @BeforeAll
    static void init(){
        System.out.println("before all");
        sequence = 0;
    }
    @Test
    @DisplayName("findById에 대한 테스트")
    void 데이터조회하기() {

    }

    @Test
    @DisplayName("Insert 메서드에 대한 테스트")
    void 데이터추가하기() { // given , when , then
        //given
        sequence++;
        //when
        Post post = new Post(sequence, "test1", "test1", 0, "testuser");
        posts.put(sequence, post);
        // then
        org.assertj.core.api.Assertions
                .assertThat(posts.get(1).getTitle().equals("test1"));
//        if(posts.get(sequence).getPostId() == sequence)
//            System.out.println("데이터 추가 성공했습니다.");
//        else
//            System.out.println("데이터 추가 실패했습니다.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("after all");
    }
}
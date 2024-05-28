package com.example.ditest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostAPIDto {
    private int postId;
    private int likes;
}

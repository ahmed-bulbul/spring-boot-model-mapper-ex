package com.intellier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

        private Long id;
        private String title;
        private String content;
        //list of comments
        private List<CommentDto> comments;

}

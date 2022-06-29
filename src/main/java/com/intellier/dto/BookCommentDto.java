package com.intellier.dto;

import com.intellier.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCommentDto {

    private Long id;
    private String title;
    private String description;
    // object author mapping to userDto
    private UserDto author;

    private Boolean isPublished;
    //list of comments
    private List<PostDto> posts;

}

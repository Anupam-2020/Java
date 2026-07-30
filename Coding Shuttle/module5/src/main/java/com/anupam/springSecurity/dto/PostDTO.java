package com.anupam.springSecurity.dto;

import com.anupam.springSecurity.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long Id;
    private String title;
    private String description;
    private UserDto author;
}

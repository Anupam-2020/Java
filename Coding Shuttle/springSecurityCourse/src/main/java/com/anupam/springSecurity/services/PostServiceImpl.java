package com.anupam.springSecurity.services;

import com.anupam.springSecurity.dto.PostDTO;
import com.anupam.springSecurity.entities.PostEntity;
import com.anupam.springSecurity.exceptions.ResourceNotFoundException;
import com.anupam.springSecurity.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper mapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(post -> mapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = mapper.map(inputPost, PostEntity.class);
        return mapper.map(postRepository.save(postEntity), PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id "+ postId));
        return mapper.map(postEntity, PostDTO.class);
    }
}

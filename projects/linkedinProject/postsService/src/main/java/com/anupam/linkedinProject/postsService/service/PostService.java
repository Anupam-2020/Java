package com.anupam.linkedinProject.postsService.service;

import com.anupam.linkedinProject.postsService.dto.PostCreateRequestDto;
import com.anupam.linkedinProject.postsService.dto.PostDto;
import com.anupam.linkedinProject.postsService.entity.Post;
import com.anupam.linkedinProject.postsService.exception.ResourceNotFoundException;
import com.anupam.linkedinProject.postsService.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper mapper;

    public PostDto createPost(PostCreateRequestDto postCreateRequestDto, Long userId) {
        log.info("Creating post for user with id: {}", postCreateRequestDto);
        Post post = mapper.map(postCreateRequestDto, Post.class);
        post.setUserId(userId);
        post = postRepository.save(post);
        return mapper.map(post, PostDto.class);
    }

    public PostDto getPostById(Long postId) {
        log.info("Getting post with id: {}", postId);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found "+ postId));
        return mapper.map(post, PostDto.class);
    }

    public List<PostDto> getAllPostsOfUser(Long userId) {
        log.info("Getting all posts of a user with ID: {}", userId);
        List<Post> postList = postRepository.findByUserId(userId);
        return postList
                .stream()
                .map((post) ->
                        mapper.map(post, PostDto.class)
        ).collect(Collectors.toList());
    }
}

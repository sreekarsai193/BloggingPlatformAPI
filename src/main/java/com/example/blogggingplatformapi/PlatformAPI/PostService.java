package com.example.blogggingplatformapi.PlatformAPI;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public BlogPost addPost(BlogPost post) {
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public BlogPost updatePost(int id,BlogPost post) {

        Optional<BlogPost> existingPostOp = postRepository.findById(id);

        if(existingPostOp.isPresent()) {
            BlogPost existingPost=existingPostOp.get();
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            existingPost.setCategory(post.getCategory());
            existingPost.setTags(post.getTags());
            existingPost.setUpdatedAt(LocalDateTime.now());
            return postRepository.save(existingPost);
        }
        else {
            return null;
        }

    }

    public BlogPost deletePost(int id) {

        BlogPost post=postRepository.findById(id).orElse(null);
        if(post!=null) {
            postRepository.delete(post);
        }
        return post;
    }

    public List<BlogPost> getAllPosts() {
        return postRepository.findAll();
    }

    public BlogPost getPostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<BlogPost> searchPosts(String term) {
        return postRepository.searchByTerm(term);
    }

}

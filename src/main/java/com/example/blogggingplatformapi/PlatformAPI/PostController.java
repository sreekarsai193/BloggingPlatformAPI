package com.example.blogggingplatformapi.PlatformAPI;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
@RestController
@RequestMapping("")
public class PostController {

    private PostService postService;
    PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/posts")
    List<BlogPost> getAllPosts(@RequestParam(required = false) String term) {

        if(term!=null && !term.trim().isEmpty()){
            List<BlogPost> posts=postService.searchPosts(term);
            return posts;
        }
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    ResponseEntity<BlogPost> getPostById(@PathVariable int id) {
           BlogPost post=postService.getPostById(id);
           if(post==null) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           }
           return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @PostMapping("/posts")
    ResponseEntity<?> createPost(@RequestBody @Valid BlogPost post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for(FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        postService.addPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @PutMapping("/posts/{id}")
    ResponseEntity<?> updatePost(@Valid @RequestBody BlogPost post, BindingResult bindingResult,
                                 @PathVariable int id) {
        if(bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for(FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        BlogPost updatedPost = postService.updatePost(id,post);
        if(updatedPost==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedPost);
    }

    @DeleteMapping("/posts/{id}")
    ResponseEntity<?> deletePost(@PathVariable int id) {
        BlogPost deletedPost=postService.deletePost(id);
        if(deletedPost==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

//    private final MessageSource messageSource;
//    PostRepository postRepository;
//    public PostController(PostRepository postRepository, @Qualifier("messageSource") MessageSource messageSource) {
//
//        this.postRepository = postRepository;
//        this.messageSource = messageSource;
//    }
//    @GetMapping("/posts")
//    List<BlogPost> getAllPosts(){
//        return postRepository.getPosts();
//    }
//
//    @GetMapping("/posts/{id}")
//    ResponseEntity<?> getPost(@PathVariable int id){
//        BlogPost post=postRepository.getPost(id);
//        if(post==null){return ResponseEntity.status(HttpStatus.NOT_FOUND).
//                body("post not found");}
//        return ResponseEntity.status(HttpStatus.OK).body(post);
//    }
//
//    @PostMapping("/posts")
//    ResponseEntity<?> addPost(@Valid @RequestBody BlogPost post,
//                                     BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            Map<String,String> errors = new HashMap<>();
//            for(FieldError error : bindingResult.getFieldErrors()){
//                errors.put(error.getField(),error.getDefaultMessage());
//            }
//
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
//        }
//        BlogPost createdPost=postRepository.addPost(post);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
//    }
//
//    @PostMapping("/posts/{id}")
//    ResponseEntity<?> updatePost(@PathVariable int id,@Valid @RequestBody BlogPost post,
//                                 BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            Map<String,String> errors = new HashMap<>();
//            for(FieldError error : bindingResult.getFieldErrors()){
//                errors.put(error.getField(),error.getDefaultMessage());
//            }
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
//        }
//
//        BlogPost updatedPost=postRepository.updatePost(id,post);
//        if(updatedPost==null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(updatedPost);
//    }
//
//    @DeleteMapping("/posts/{id}")
//    ResponseEntity<?> deletePost(@PathVariable int id){
//        BlogPost post=postRepository.deletePost(id);
//        if(post==null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
//        }
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

}

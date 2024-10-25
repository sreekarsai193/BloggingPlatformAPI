package com.example.blogggingplatformapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;
import com.example.blogggingplatformapi.PlatformAPI.BlogPost;
import com.example.blogggingplatformapi.PlatformAPI.PostRepository;

@SpringBootApplication
public class    BlogggingPlatformApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlogggingPlatformApiApplication.class, args);
    }
    final PostRepository postRepository;
    BlogggingPlatformApiApplication(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

//    @Bean
//    CommandLineRunner runner(){
//        return args->{
//            BlogPost post=new BlogPost(1,"firstpost","no content",
//                    "afkjlfk",new ArrayList<>(Arrays.asList("abc","def")),LocalDateTime.now(),
//                    LocalDateTime.now());
//            postRepository.addPost(post);
//
//        };
//
//   }

}

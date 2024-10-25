package com.example.blogggingplatformapi.PlatformAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public interface PostRepository extends JpaRepository<BlogPost,Integer> {

    @Query("SELECT p FROM BlogPost p WHERE p.title LIKE %:term% OR p.content LIKE %:term% OR " +
            "p.category LIKE %:term%")
    List<BlogPost> searchByTerm(@Param("term") String term);
//    List<BlogPost> posts=new ArrayList<>();
//    private AtomicInteger counter=new AtomicInteger(1);
//    public BlogPost addPost(BlogPost post) {
//        post.setId(counter.getAndIncrement());
//        post.setCreatedAt(LocalDateTime.now());
//        post.setUpdatedAt(LocalDateTime.now());
//        posts.add(post);
//        return post;
//    }
//    public BlogPost updatePost(int id, BlogPost post) {
//        for(BlogPost p : posts) {
//            if(p.getId()==id) {
//                p.setTitle(post.getTitle());
//                p.setContent(post.getContent());
//                p.setCategory(post.getCategory());
//                p.setTags(post.getTags());
//                p.setUpdatedAt(LocalDateTime.now());
//                return p;
//            }
//        }
//        return null;
//
//    }
//
//    public BlogPost deletePost(int id) {
//        for(BlogPost p : posts) {
//            if(p.getId()==id) {
//                posts.remove(p);
//                return p;
//            }
//        }
//        return null;
//    }
//    List<BlogPost> getPosts() {
//        return posts;
//    }
//    public BlogPost getPost(int id) {
//        for(BlogPost p : posts) {
//            if(p.getId()==id) {
//                return p;
//            }
//        }
//        return null;
//    }
}

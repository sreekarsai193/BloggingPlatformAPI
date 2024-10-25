package com.example.blogggingplatformapi.PlatformAPI;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity(name="BlogPost")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column(name="Title")
     @NotNull
     @NotEmpty(message = "title should not be empty")

     String title;

     @Column(name="Content")
    @NotNull
    @NotEmpty(message = "content should not be empty")
     String content;

     @Column(name="Category")
    String category;

     @Column(name="tags")
     @Convert(converter = StringListConverter.class)
    ArrayList<String> tags;

    @Column(name="Created at")
    LocalDateTime createdAt;

    @Column(name="Updated at")
    LocalDateTime updatedAt;

    public BlogPost( String title, String content,
                    String category, ArrayList<String> tags,
                    LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.tags = tags;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public BlogPost() {}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}

package com.example.moodrecommendation.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String mood;
    private LocalDateTime createdAt;

    // ----- GETTERS & SETTERS -----
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getMood() {
        return mood;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

package com.example.moodrecommendation.Entity;


import jakarta.persistence.*;

@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mood;   // SAD, HAPPY
    private String type;   // MUSIC, ACTIVITY, QUOTE
    private String content;

    // ----- GETTERS & SETTERS -----
    public Long getId() {
        return id;
    }

    public String getMood() {
        return mood;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

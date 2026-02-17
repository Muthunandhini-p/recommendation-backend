package com.example.moodrecommendation.dto;

import java.util.List;

public class Recommendation {

    private List<String> activityRecommendation;
    private List<Song> musicRecommendation;
    private String quote;

    public Recommendation() {
    }

    public Recommendation(List<String> activityRecommendation,
                          List<Song> musicRecommendation,
                          String quote) {
        this.activityRecommendation = activityRecommendation;
        this.musicRecommendation = musicRecommendation;
        this.quote = quote;
    }

    public List<String> getActivityRecommendation() {
        return activityRecommendation;
    }

    public void setActivityRecommendation(List<String> activityRecommendation) {
        this.activityRecommendation = activityRecommendation;
    }

    public List<Song> getMusicRecommendation() {
        return musicRecommendation;
    }

    public void setMusicRecommendation(List<Song> musicRecommendation) {
        this.musicRecommendation = musicRecommendation;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}

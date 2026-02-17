package com.example.moodrecommendation.repository;

import com.example.moodrecommendation.entity.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoodEntryRepository
        extends JpaRepository<MoodEntry, Long> {

    List<MoodEntry> findByUsername(String username);
}

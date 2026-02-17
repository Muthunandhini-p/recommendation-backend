package com.example.moodrecommendation.service;
import com.example.moodrecommendation.Entity.MoodEntry;
import com.example.moodrecommendation.Entity.Recommendation;
import com.example.moodrecommendation.repository.MoodEntryRepository;
import com.example.moodrecommendation.repository.RecommendationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MoodService {

    private final MoodEntryRepository moodRepo;
    private final RecommendationRepository recRepo;

    public MoodService(MoodEntryRepository moodRepo,
                       RecommendationRepository recRepo) {
        this.moodRepo = moodRepo;
        this.recRepo = recRepo;
    }

    public void saveMood(String username, String mood) {
        MoodEntry entry = new MoodEntry();
        entry.setUsername(username);
        entry.setMood(mood);
        entry.setCreatedAt(LocalDateTime.now());
        moodRepo.save(entry);
    }

    public Map<String, Recommendation> getRecommendations(String mood) {

        List<Recommendation> list = recRepo.findByMood(mood);

        Map<String, List<Recommendation>> grouped =
                list.stream()
                        .collect(Collectors.groupingBy(Recommendation::getType));

        Map<String, Recommendation> result = new HashMap<>();
        Random random = new Random();

        grouped.forEach((type, items) -> {
            result.put(type, items.get(random.nextInt(items.size())));
        });

        return result;
    }

    public List<MoodEntry> getHistory(String username) {
        return moodRepo.findByUsername(username);
    }
}


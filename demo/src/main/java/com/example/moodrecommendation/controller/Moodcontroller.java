package com.example.moodrecommendation.controller;

import com.example.moodrecommendation.entity.MoodEntry;
import com.example.moodrecommendation.dto.MoodRequest;
import com.example.moodrecommendation.dto.Recommendation;
import com.example.moodrecommendation.service.MoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Moodcontroller {

    private final MoodService service;

    public Moodcontroller(MoodService service) {
        this.service = service;
    }

    @PostMapping("/mood")
    public ResponseEntity<String> saveMood(@RequestBody MoodRequest request) {

        service.saveMood(
                request.getUsername(),
                request.getMood()
        );

        return ResponseEntity.ok("Mood saved successfully");
    }

    @GetMapping("/recommend/{mood}")
    public ResponseEntity<Recommendation> recommend(@PathVariable String mood) {

        return ResponseEntity.ok(service.getRecommendations(mood));
    }

    // Mood history
    @GetMapping("/history/{username}")
    public ResponseEntity<List<MoodEntry>> history(@PathVariable String username) {

        return ResponseEntity.ok(service.getHistory(username));
    }
    @DeleteMapping("/mood/{id}")
    public ResponseEntity<String> deleteMood(@PathVariable Long id) {
        service.deleteMood(id);
        return ResponseEntity.ok("Mood deleted successfully");
    }

}

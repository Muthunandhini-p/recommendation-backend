
package com.example.moodrecommendation.controller;

import com.example.moodrecommendation.Entity.MoodEntry;
import com.example.moodrecommendation.Entity.Recommendation;
import com.example.moodrecommendation.service.MoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Moodcontroller {

    private final MoodService service;

    public Moodcontroller(MoodService service) {
        this.service = service;
    }

    @PostMapping("/mood")
    public ResponseEntity<String> saveMood(
            @RequestParam String username,
            @RequestParam String mood) {

        service.saveMood(username, mood);
        return ResponseEntity.ok("Mood saved");
    }

    @GetMapping("/recommend/{mood}")
    public ResponseEntity<Map<String, Recommendation>> recommend(
            @PathVariable String mood) {

        return ResponseEntity.ok(service.getRecommendations(mood));
    }

    @GetMapping("/history/{username}")
    public ResponseEntity<List<MoodEntry>> history(
            @PathVariable String username) {

        return ResponseEntity.ok(service.getHistory(username));
    }
}

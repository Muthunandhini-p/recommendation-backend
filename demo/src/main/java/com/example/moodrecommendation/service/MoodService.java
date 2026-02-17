package com.example.moodrecommendation.service;

import com.example.moodrecommendation.entity.MoodEntry;
import com.example.moodrecommendation.dto.Recommendation;
import com.example.moodrecommendation.dto.Song;
import com.example.moodrecommendation.repository.MoodEntryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MoodService {

    private final MoodEntryRepository moodRepo;

    public MoodService(MoodEntryRepository moodRepo) {
        this.moodRepo = moodRepo;
    }

    // ✅ SAVE MOOD
    public void saveMood(String username, String mood) {

        MoodEntry entry = new MoodEntry();
        entry.setUsername(username);
        entry.setMood(mood);
        moodRepo.save(entry);
    }
    public List<MoodEntry> getHistory(String username) {
        return moodRepo.findByUsername(username);
    }
    public Recommendation getRecommendations(String mood) {

        switch (mood.toLowerCase()) {

            case "happy":
                return getHappyRecommendation();

            case "sad":
                return getSadRecommendation();

            case "angry":
                return getAngryRecommendation();

            default:
                return getDefaultRecommendation();
        }
    }
    private Recommendation getHappyRecommendation() {

        List<String> activities = Arrays.asList(
                "Go for a walk in the park",
                "Dance to your favorite song",
                "Call a close friend",
                "Watch a comedy video"
        );

        List<Song> songs = Arrays.asList(
                new Song("Happy Vibes",
                        "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"),
                new Song("Feel Good",
                        "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3")
        );

        String quote = "Happiness is a direction, not a place.";

        return new Recommendation(activities, songs, quote);
    }

    private Recommendation getSadRecommendation() {

        List<String> activities = Arrays.asList(
                "Write down your feelings",
                "Take deep breaths for 5 minutes",
                "Listen to calming music",
                "Go outside for fresh air"
        );

        List<Song> songs = Arrays.asList(
                new Song("Calm Soul",
                        "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3"),
                new Song("Peaceful Mind",
                        "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-4.mp3")
        );

        String quote = "This too shall pass.";

        return new Recommendation(activities, songs, quote);
    }
    private Recommendation getAngryRecommendation() {

        List<String> activities = Arrays.asList(
                "Do a quick workout",
                "Take 10 deep breaths",
                "Go for a fast walk",
                "Listen to relaxing music"
        );

        List<Song> songs = Arrays.asList(
                new Song("Relax Mode",
                        "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-5.mp3"),
                new Song("Cool Down",
                        "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-6.mp3")
        );

        String quote = "For every minute you remain angry, you give up sixty seconds of peace.";

        return new Recommendation(activities, songs, quote);
    }

    // 🌿 DEFAULT
    private Recommendation getDefaultRecommendation() {

        return new Recommendation(
                List.of("Take a deep breath and relax"),
                List.of(new Song("Relax Music",
                        "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-7.mp3")),
                "Stay calm and keep moving forward."
        );
    }
    public void deleteMood(Long id) {
        moodRepo.deleteById(id);
    }

}

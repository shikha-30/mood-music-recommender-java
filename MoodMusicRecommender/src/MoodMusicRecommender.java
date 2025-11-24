import java.io.*;
import java.util.*;

public class MoodMusicRecommender {

    private static final String FAVORITE_FILE = "favorites.txt";

    public static void main(String[] args) {

        Map<String, List<String>> moodSongs = new HashMap<>();

        // Predefined songs
        moodSongs.put("sad", new ArrayList<>(Arrays.asList(
                "CO2 — Prateek Kuhad",
                "Daylight — David Kushner",
                "Let Her Go — Passenger",
                "Heather — Conan Gray",
                "Hold On — Chord Overstreet",
                "Chemtrails Over the Country Club — Lana Del Rey",
                "Summertime Sadness — Lana Del Rey"
        )));

        moodSongs.put("happy", new ArrayList<>(Arrays.asList(
                "Blank Space — Taylor Swift",
                "Older — Sasha Alex Sloan",
                "Rewrite the Stars — James Arthur & Anne-Marie",
                "Baawra — Kushagra",
                "Dhun — Arijit Singh"
        )));

        moodSongs.put("energetic", new ArrayList<>(Arrays.asList(
                "There’s Nothing Holdin’ Me Back — Shawn Mendes",
                "Stitches — Shawn Mendes",
                "Animals — Maroon 5",
                "Blinding Lights — The Weeknd",
                "Shake It Off — Taylor Swift",
                "Believer — Imagine Dragons"
        )));

        moodSongs.put("romantic", new ArrayList<>(Arrays.asList(
                "Until I Found You — Stephen Sanchez",
                "Young and Beautiful — Lana Del Rey",
                "Say Yes to Heaven — Lana Del Rey",
                "I Wanna Be Yours — Arctic Monkeys",
                "Die With a Smile — Lady Gaga & Bruno Mars",
                "It’s You — Ali Gatie"
        )));

        moodSongs.put("chill", new ArrayList<>(Arrays.asList(
                "Tere Hoke Rahoon — Arijit Singh",
                "Kehne Lagaa — Rushil Aswal",
                "Kasturi — Arijit Singh",
                "Aa Jao Meri Tamanna — Javed Ali",
                "Jaavedaan Hai — KK",
                "Mid December — Peech"
        )));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n🎵 Mood-Based Music System");
            System.out.println("1. View songs by mood");
            System.out.println("2. Add your own song to a mood");
            System.out.println("3. Save a song to Favorite List");
            System.out.println("4. View Favorite Songs");
            System.out.println("5. Exit");
            System.out.println("6. Detect mood from a sentence");  // NEW
            System.out.print("\nChoose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter mood (happy, sad, energetic, romantic, chill): ");
                    String mood = sc.nextLine().toLowerCase();

                    showSongs(moodSongs, mood);
                    break;

                case 2:
                    System.out.print("Enter mood to add song in: ");
                    String moodAdd = sc.nextLine().toLowerCase();

                    if (moodSongs.containsKey(moodAdd)) {
                        System.out.print("Enter the song name: ");
                        String newSong = sc.nextLine();

                        moodSongs.get(moodAdd).add(newSong);
                        System.out.println("✔ Song added successfully!");
                    } else {
                        System.out.println("❌ Invalid mood!");
                    }
                    break;

                case 3:
                    System.out.print("Enter song name to save as favorite: ");
                    String favSong = sc.nextLine();

                    saveToFile(favSong);
                    System.out.println("💾 Saved to favorites!");
                    break;

                case 4:
                    System.out.println("\n❤️ Your Favorite Songs:");
                    readFavoriteFile();
                    break;

                case 5:
                    System.out.println("👋 Exiting... Goodbye!");
                    sc.close();
                    return;

                case 6:   // NEW FEATURE
                    System.out.print("Write how you feel: ");
                    String sentence = sc.nextLine().toLowerCase();

                    String detectedMood = detectMood(sentence);  // NEW

                    if (detectedMood == null) {
                        System.out.println("Could not detect mood. Try again.");
                    } else {
                        System.out.println("\nDetected mood: " + detectedMood.toUpperCase());
                        showSongs(moodSongs, detectedMood);  // auto show songs
                    }
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    // NEW - function to show songs
    private static void showSongs(Map<String, List<String>> moodSongs, String mood) {
        if (moodSongs.containsKey(mood)) {
            System.out.println("\n🎶 Songs for mood: " + mood);
            for (String song : moodSongs.get(mood)) {
                System.out.println("• " + song);
            }
        } else {
            System.out.println("❌ Invalid mood!");
        }
    }

    // NEW - simple keyword-based mood detector
    private static String detectMood(String text) {

        if (text.contains("sad") || text.contains("low") || text.contains("cry") || text.contains("upset"))
            return "sad";

        if (text.contains("happy") || text.contains("good") || text.contains("excited") || text.contains("great"))
            return "happy";

        if (text.contains("energy") || text.contains("workout") || text.contains("pump") || text.contains("fast"))
            return "energetic";

        if (text.contains("love") || text.contains("romantic") || text.contains("crush") || text.contains("someone"))
            return "romantic";

        if (text.contains("relax") || text.contains("calm") || text.contains("peace") || text.contains("chill"))
            return "chill";

        return null; // no match
    }

    private static void saveToFile(String song) {
        try (FileWriter fw = new FileWriter(FAVORITE_FILE, true)) {
            fw.write(song + "\n");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    private static void readFavoriteFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FAVORITE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("• " + line);
            }
        } catch (IOException e) {
            System.out.println("No favorites found or unable to read file.");
        }
    }
}
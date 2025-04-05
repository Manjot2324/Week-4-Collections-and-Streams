import java.util.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Convert text into words (split by spaces and punctuation) (^ -> NOT)
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");   

        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> repeatedWords = new HashSet<>();

        // Count occurrences of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            if (wordCount.get(word) > 1) {
                repeatedWords.add(word);
            }
        }

        // Print the repeated words
        System.out.println(String.join(", ", repeatedWords));
    }
}


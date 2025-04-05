import java.util.*;
import java.util.regex.*;

public class ExtractProgrammingLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet. C++ is also interesting!";

        // List of programming languages to check
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift", "PHP", "Kotlin");

        // Convert list into a regex pattern (handles word boundaries and special characters like C++)
        String regex = "\\b(" + String.join("|", languages).replace("C++", "C\\+\\+") + ")\\b" ; 

        // Compile pattern
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        // Store matched programming languages
        Set<String> extractedLanguages = new HashSet<>();
        while (matcher.find()) {
            extractedLanguages.add(matcher.group()); // Add matched language to prevent duplicates
        }

        // Print extracted languages
        System.out.println(String.join(", ", extractedLanguages));
    }
}

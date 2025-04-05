import java.util.Arrays;
import java.util.List;

public class CensorBadWords {
    public static String censorWords(String sentence, List<String> badWords) {
        for (String badWord : badWords) {
            String replacement = "*".repeat(badWord.length()); // Create asterisks('*') of same length
            sentence = sentence.replaceAll( "(?i)\\b" + badWord + "\\b" , replacement); // '\\b'-> one whole word & (?i) -> case-insensitive
        }
        return sentence;
    }

    public static void main(String[] args) {
        String input = "This is a damn badminton example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");

        String output = censorWords(input, badWords);
        System.out.println(output);
    }
}

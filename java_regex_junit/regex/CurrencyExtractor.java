import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        
        // Regex pattern to match currency values
        Pattern pattern = Pattern.compile("\\$?\\d+\\d.\\d{2}") ; 
        Matcher matcher = pattern.matcher(text);
        
        List<String> currencyValues = new ArrayList<>();
        
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        
        // Print extracted values
        System.out.println(String.join(", ", currencyValues));
    }
}


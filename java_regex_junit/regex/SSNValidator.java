import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String text1 = "My SSN is 123-45-6789.";
        String text2 = "My SSN is 123456789.";

        validateSSN(text1);
        validateSSN(text2);
    }

    public static void validateSSN(String text) {
        // Regex pattern for SSN in "XXX-XX-XXXX" format ( '\\b' stands for - word boundary -> match occurs of the full word rather than picking up in the middle)
        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("✅ \"" + matcher.group() + "\" is valid");
        } else {
            System.out.println("❌ No valid SSN found");
        }
    }
}


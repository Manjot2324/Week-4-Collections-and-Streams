import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dates {
  public static void main(String[] args) {

    String regex = "(https?://[\\w.-]+(?:\\.[a-zA-Z]{2,6})+\\S*)" ; //URLs
     
    Pattern pattern = Pattern.compile(regex) ;

    String inp = "Visit https://www.google.com and http://example.org for more info" ; 
    Matcher urls = pattern.matcher(inp) ;

    while (urls.find()) {
      System.out.println("Matched: " + urls.group());
    }
  }
}


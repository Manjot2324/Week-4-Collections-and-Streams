import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class capitalise {
  public static void main(String[] args) {

    String regex = "\\b\\[A-Z][a-z]*\\b" ; // '\\b' ensuring that the match is a whole word rather than being a part of another word 
     
    Pattern pattern = Pattern.compile(regex) ;

    String inp = "The Eiffel Tower is in Paris and the Statue of Liberty is in NewYork." ; 
    Matcher words = pattern.matcher(inp) ;

    while (words.find()) {
      System.out.println("Matched: " + words.group());
    }
  }
}

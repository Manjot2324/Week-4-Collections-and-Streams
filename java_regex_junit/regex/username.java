
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class username {
  public static void main(String[] args) {
    String regex = "[a-zA-Z0-9_]+" ;
    Pattern pattern = Pattern.compile(regex) ; 
    
    String inp ="user_123,  123user,us" ;
    Matcher matcher = pattern.matcher(inp) ;

    while (matcher.find()) {
      System.out.println("Matched: "+matcher.group());
    }
  }
}

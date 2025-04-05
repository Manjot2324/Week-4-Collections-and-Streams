import java.util.regex.*;

public class emails {
  public static void main(String[] args) {

    String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}" ; 
    Pattern pattern = Pattern.compile(regex) ; 
   
    String inp = "Contact us at support@example.com and info@company.org" ;
    Matcher emails = pattern.matcher(inp) ;  

    while (emails.find()) {
      System.out.println("Matched: "+emails.group());
    }
    
  }
}

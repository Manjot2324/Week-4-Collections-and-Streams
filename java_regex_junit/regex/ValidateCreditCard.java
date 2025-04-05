public class ValidateCreditCard {
  public static boolean isValidCard(String cardNumber) {
      String visa = "^4\\d{15}$" ;
      String mastercard = "^5\\d{15}$" ; 
      
      if (cardNumber.matches(visa)) {
        System.out.print("Visa"+" -> ");
        return true; 
      }
      else if(cardNumber.matches(mastercard)){
        System.out.print("Mastercard"+" -> ");
        return true ; 
      }return false ; 
  }

  public static void main(String[] args) {
      System.out.println(isValidCard("4123456789012345")); // Visa → true
      System.out.println(isValidCard("5123456789012345")); // MasterCard → true
      System.out.println(isValidCard("3123456789012345")); // Invalid → false
      System.out.println(isValidCard("41234567890123"));   // Invalid (length) → false
  }
}


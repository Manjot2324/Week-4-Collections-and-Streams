

public class licensePlate {
  public static boolean isValidLicensePlate(String inp) {
    String regex = "^[A-Z]{2}\\d{4}$";

    return inp.matches(regex)  ; 
  }

  public static void main(String[] args) {
    System.out.println(isValidLicensePlate("AB1234")); 
    System.out.println(isValidLicensePlate("A12345")); 
    System.out.println(isValidLicensePlate("XY9876")); 
    System.out.println(isValidLicensePlate("ab1234")); 
    System.out.println(isValidLicensePlate("XYZ123")); 

  }
}

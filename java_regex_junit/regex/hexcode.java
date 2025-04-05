public class hexcode {
  public static boolean isValidHexColor(String color) {
    String regex = "^#([A-Fa-f0-9]{6})$";
    return color.matches(regex);
  }

  public static void main(String[] args) {
    System.out.println(isValidHexColor("#000000")); 
    System.out.println(isValidHexColor("#123ABZ")); // false (Z is not valid)
    System.out.println(isValidHexColor("123ABC"));
  }
}

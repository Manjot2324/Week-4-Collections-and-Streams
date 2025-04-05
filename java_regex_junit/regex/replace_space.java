public class replace_space {
  public static void main(String[] args) {
    String str = "            This is an example       with multiple spaces." ; 
    String output = str.trim().replaceAll("\\s+", "") ; 
    System.out.println(output);
  }
}

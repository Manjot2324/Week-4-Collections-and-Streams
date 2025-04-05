public class ValidateIPAddress {
  public static boolean isValidIPv4(String ip) {
      String ipv4Pattern = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]?|0)\\.){3}"
                         + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]?|0)$";

      return ip.matches(ipv4Pattern);
  }

  public static void main(String[] args) {
      String ip1 = "192.168.1.1";
      String ip2 = "256.100.50.25"; // Invalid
      String ip3 = "0.0.0.0";
      String ip4 = "172.16.254.1";

      System.out.println(ip1 + " is valid: " + isValidIPv4(ip1)); // true
      System.out.println(ip2 + " is valid: " + isValidIPv4(ip2)); // false
      System.out.println(ip3 + " is valid: " + isValidIPv4(ip3)); // true
      System.out.println(ip4 + " is valid: " + isValidIPv4(ip4)); // true
  }
}

//valid ipv

public class prob_str28 {
  public String validateIPv4(String IP) {
    String nums[] = IP.split("\\.", -1);
    for (String x : nums) {
      // Validate integer in range (0, 255):
      // 1. length of chunk is between 1 and 3
      if (x.length() == 0 || x.length > 3) {
        return "Neigher";
      }
      // 2. no extra leading zeros
      if (x.charAt(0) == 0 && x.length != 1) {
        return "Neigher";
      }
      // 3. only digits are allowed
      for (char ch : x.toCharArray()) {
        if (!Character.isDigit((ch)))
          return "Neither";
      }

      if(Integer.parseInt(x) <0 || Integer.parseInt(x)> 255) return "Neither"

    }
        return "IPv4";

  }

  public String validateIPv6(String IP) {
    String[] nums = IP.split(":", -1);
    String hexdigits = "0123456789abcdefABCDEF";
    for (String x : nums) {
      // Validate hexadecimal in range (0, 2**16):
      // 1. at least one and not more than 4 hexdigits in one chunk
      if (x.length() == 0 || x.length() > 4)
        return "Neither";
      // 2. only hexdigits are allowed: 0-9, a-f, A-F
      for (Character ch : x.toCharArray()) {
        if (hexdigits.indexOf(ch) == -1)
          return "Neither";
      }
    }
    return "IPv6";
  }
}

//new 
https:// drive.google.com/file/d/15ck14KplQW0pAW0vUWYPx11psp4IIiCf/view

//old
https:// drive.google.com/open?id=16J_1YYow17p6PYwKklM7X0-EDzb0fDZm
//check string is palindrome or not
public class prob_str1 {
  static boolean isPalindrome(String str) {
    int flag = 0;
    int n = str.length();
    if (n == 0) {
      return true;
    }
    for (int i = 0; i < n / 2; i++) {
      if (str.charAt(i) == str.charAt(n - i - 1)) {
        flag = 1;
      } else {
        flag = 0;
        break;
      }
    }

    return flag == 1;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(""));
  }

}

import java.util.*;

public class prob_str2 {
  static int maxLeng(String str) {
    int currlen = 0, maxLeng = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        if (maxLeng < currlen) {
          maxLeng = currlen;
        }
        currlen = 0;
      } else {
        currlen++;
      }
    }
    if (currlen > maxLeng) {
      maxLeng = currlen;
    }
    return maxLeng;
  }

  static int maxLen2(String str) {
    int maxLeng = Integer.MIN_VALUE;

    String arr[] = str.split(" ");
    for (int i = 0; i < arr.length; i++) {
      int currlen = arr[i].length();
      if (currlen > maxLeng) {
        maxLeng = currlen;
      }
    }
    return maxLeng;

  }

  public static void main(String[] args) {
    System.out.println(maxLen2("fsdhf df sdf dfj osidf sdf sodif sdf"));
    char aa = 'a';
    int a = (int) aa;
    System.out.println(a);
  }
}

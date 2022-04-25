import java.util.Arrays;

//Longest substring without repeating character
public class prob52 {

  public static void main(String[] args) {
    String s = "pwwkew";

    int arr[] = new int[256];
    Arrays.fill(arr, -1);
    int maxlen = 0, start = -1;
    for (int i = 0; i < s.length(); i++) {
      if (arr[s.charAt(i)] > start) {
        start = arr[s.charAt(i)];
      }
      arr[s.charAt(i)] = i;
      maxlen = Math.max(maxlen, i - start);
    }
    System.out.println(maxlen);
    // kew
  }


}

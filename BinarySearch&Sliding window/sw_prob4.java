import java.util.Vector;

// check whether subarray of length k is palindrome or not

public class sw_prob4 {
  static boolean isPalindrome(int num) {
    int temp = num, reverse = 0;
    while (temp > 0) {
      reverse = reverse * 10 + (temp % 10);
      temp /= 10;
    }

    if (num == reverse) {
      return true;
    }

    return false;
  }

  static int palindromeSubarrray(int[] arr, int k) {
    int num = 0;
    int n = arr.length;
    for (int i = 0; i < k; i++) {
      num = num * 10 + arr[i];
    }
    if (isPalindrome(num)) {
      return 0;
    }

    for (int i = k; i < n; i++) {
      num = arr[i] + (num % (int) Math.pow(10, k - 1)) * 10;
      if (isPalindrome(num)) {
        return i - k + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = { 2, 3, 4, 4, 3, 2 };
    System.out.println(palindromeSubarrray(arr, 2));
  }
}

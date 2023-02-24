import java.util.ArrayList;
import java.util.*;

public class prob_str6 {
  public static void subSeq(String s, String ans) {
    if (s.length() == 0) {
      System.out.println(ans);
      return;
    }
    char ch = s.charAt(0);
    String ros = s.substring(1);
    subSeq(ros, ans);
    subSeq(ros, ans + ch);

  }

  static void subSeqAsc(String s, String ans) {
    if (s.length() == 0) {
      System.out.println(ans);
      return;
    }
    char ch = s.charAt(0);
    int code = ch;
    String ros = s.substring(1);

    subSeqAsc(ros, ans);
    subSeqAsc(ros, ans + ch);
    subSeqAsc(ros, ans + code);
  }

  public static List<int[]> subSeqII(int[] nums) {
    ArrayList<int[]> result = new ArrayList<>();
    int index = 0;
    subseqIIUtil(nums, result, new int[nums.length], index);
    return result;
  }

  public static void subseqIIUtil(int[] nums, ArrayList<int[]> result, int[] temp, int index) {
    if (index == nums.length) {
      result.add(temp);
      for (int i = 0; i < temp.length; i++) {
        if (temp[i] == 0) {
          System.out.print(nums[i] + " ");
        }
      }
      System.out.println();
      return;
    }

    temp[index] = 1;
    subseqIIUtil(nums, result, temp, index + 1);
    temp[index] = 0;
    subseqIIUtil(nums, result, temp, index + 1);
  }

  public static void main(String[] args) {
    // subSeq("abc", "");
    int arr[] = { 1, 2, 3 };
    subSeqII(arr);
  }
}

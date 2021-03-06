import java.util.Vector;
import java.util.*;

/**
 * 
 * Arrange given numbers to form the biggest number | Set 1
 * 
 */

public class array_prob21 {

  // using string
  static void printLargest(Vector<String> arr) {
    Collections.sort(arr, new Comparator<String>() {
      // A comparison function which is used by
      // sort() in printLargest()
      @Override
      public int compare(String X, String Y) {

        // first append Y at the end of X
        String XY = X + Y;

        // then append X at the end of Y
        String YX = Y + X;
        // Now see which of the two
        // formed numbers
        // is greater
        // return XY.compareTo(YX) > 0 ? -1 : 1;
        return YX.compareTo(XY);

      }
    });

    Iterator it = arr.iterator();
    while (it.hasNext()) {
      System.out.print(it.next());
    }
  }

  // public static String findLargestNumber(List<Integer> nums) {
  // // sort using a custom function object
  // Collections.sort(nums, (a, b) -> (String.valueOf(b) +
  // a).compareTo(String.valueOf(a) + b));
  // return nums.stream()
  // .map(Object::toString)
  // .collect(Collectors.joining(""));
  // }
  // // using int
  // public static String largestNumber(List<Integer> arr) {
  // // finding number of digits in maximum element
  // // present in array
  // int n = Collections.max(arr).toString().length();
  // ArrayList<ExtendedNum> en = new ArrayList<ExtendedNum>();
  // for (int i = 0; i < arr.size(); i++)
  // en.add(new ExtendedNum(arr.get(i),
  // n));

  // // sort based on modified value
  // Collections.sort(en, (p1, p2) -> (int) (p2.modifiedValue -
  // p1.modifiedValue));

  // StringBuilder sb = new StringBuilder();
  // for (int i = 0; i < en.size(); i++)
  // sb.append(new StringBuilder(Long.toString(en.get(i).originalValue)));

  // // To remove any zeroes at head.
  // BigInteger bi = new BigInteger(sb.toString());

  // return bi.toString();
  // }

  public static void main(String[] args) {

    Vector<String> arr;
    arr = new Vector<>();

    // output should be 6054854654
    arr.add("54");
    arr.add("546");
    arr.add("548");
    arr.add("60");
    printLargest(arr);
  }
}

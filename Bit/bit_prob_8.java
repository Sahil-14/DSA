//Find Two Missing Numbers
// T = o(n)
// S = o(1)
public class bit_prob_8 {
  public static void twoMissing(int arr[], int n) {
    int xor = 0;
    for (int i = 0; i < arr.length; i++) {
      xor = xor ^ arr[i];
    }

    for (int i = 1; i <= n; i++) {
      xor = xor ^ i;
    }

    // get set bit in xor
    int set_bit_no = xor & ~(xor - 1);
    // int set_bit_no = xor & -xor;;

    // Now divide elements in two sets by comparing
    // rightmost set bit of XOR with bit at same
    // position in each element.
    int x = 0, y = 0;
    for (int i = 0; i < arr.length; i++) {
      if ((arr[i] & set_bit_no) > 0) {
        x = x ^ arr[i];
      } else {
        y = y ^ arr[i];
      }
    }

    for (int i = 1; i <= n; i++) {
      if ((i & set_bit_no) > 0) {
        x = x ^ i;
      } else {
        y = y ^ i;
      }
    }
    
    System.out.println(x);
    System.out.println(y);
  }

  public static void main(String[] args) {
    int arr[] = { 1, 3, 5, 6 };

    // Range of numbers is 2 plus size of array
    int n = 2 + arr.length;
    twoMissing(arr, n);
  }
}

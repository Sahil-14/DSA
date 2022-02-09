//Given a number N having only one ‘1’ and all other ’0’s in its binary representation,
// find position of the only set bit. If there are 0 or more than 1 set bit the answer should be -1.
// Position of  set bit '1' should be counted starting with 1 from LSB side in binary representation of the number.

public class bit_prob_5 {
  int findPosition(int N) {

    if (n != 0 && (n & (n - 1)) == 0)
      return -1;

    int i = 1, pos = 1;

    // Iterate through bits of n till we find a set bit
    // i&n will be non-zero only when 'i' and 'n' have a set bit
    // at same position
    while ((i & N) == 0) {

      i = i << 1;
      ++pos;
    }

    return pos;
  }
  
}

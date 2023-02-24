import java.util.HashMap;

// Find Recurring Sequence in a Fraction
/**
 * Input : Numerator = 8, Denominator = 3
 * Output : Recurring sequence is 6
 * Explanation : 8/3 = 2.66666666.......
 * 
 * Input : Numerator = 50, Denominator = 22
 * Output : Recurring sequence is 27
 * Explanation : 50/22 = 2.272727272.....
 * 
 * Input : Numerator = 11, Denominator = 2
 * Output : No recurring sequence
 * Explanation : 11/2 = 5.5
 * 
 * 
 * 
 * Let us simulate the process of converting fractions to decimals. Let us look
 * at the part where we have already figured out the integer part, which is
 * floor(numerator/denominator). Now we are left with ( remainder =
 * numerator%denominator ) / denominator.
 * If you remember the process of converting to decimal, at each step we do the
 * following :
 * 
 * Multiply the remainder by 10.
 * Append the remainder/denominator to the result.
 * Remainder = remainder % denominator.
 * 
 * 
 * At any moment, if the remainder becomes 0, we are done.
 * However, when there is a recurring sequence, the remainder never becomes 0.
 * For example, if you look at 1/3, the remainder never becomes 0.
 * Below is one important observation :
 * If we start with the remainder ‘rem’ and if the remainder repeats at any
 * point in time, the digits between the two occurrences of ‘rem’ keep
 * repeating.
 * So the idea is to store seen remainders in a map. Whenever a remainder
 * repeats, we return the sequence before the next occurrence.
 * 
 * Below is the implementation of the above idea.
 */

public class prob10 {
  static String fractionToDecimal(int numr, int denr) {

    // Initialize result
    String res = "";
    // Create a map to store already
    // seen remainders. Remainder is
    // used as key and its position in
    // result is stored as value.
    // Note that we need position for
    // cases like 1/6. In this case,
    // the recurring sequence doesn't
    // start from first remainder.
    HashMap<Integer, Integer> mp = new HashMap<>();
    mp.clear();

    int rem = numr % denr;

    while ((rem != 0) && (!mp.containsKey(rem))) {
      mp.put(rem, res.length());

      rem = rem * 10;
      int result_part = rem / denr;
      res += String.valueOf(result_part);
      rem = rem % denr;
    }

    if (rem == 0)
      return "";
    else if (mp.containsKey(rem))
      return res.substring(mp.get(rem));
    return "";
  }

  public static void main(String[] args) {
    int numr = 8, denr = 3;
    String res = fractionToDecimal(numr, denr);
    if (res == "")
      System.out.print("No recurring sequence");
    else
      System.out.print("Recurring sequence is "
          + res);
  }
}

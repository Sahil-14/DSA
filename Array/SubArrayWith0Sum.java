import java.util.HashSet;
import java.util.Set;

public class SubArrayWith0Sum {
    static Boolean zeroSumSubaray(int arr[]) {
        Set<Integer> hs = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if(arr[i] == 0 ||sum ==0 || hs.contains(sum))
                return true;
            hs.add(sum);

        }
        return false;

    }
    public static void main(String arg[])
    {
        int arr[] = { -3, 2, 3, 0, 6 };
        if (zeroSumSubaray(arr))
            System.out.println(
                "Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");
    }
}


// greedy starts
//Greedy Algorithm to find Minimum number of Coins
/**
 * Given a value V, if we want to make a change for V Rs, and we have an
 * infinite supply of each of the denominations in Indian currency, i.e., we
 * have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued
 * coins/notes, what is the minimum number of coins and/or notes needed to make
 * the change?
 */
import java.util.*;

public class prob93 {

    static int deno[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
    static int n = deno.length;

    static void findMin(int val) {
        Vector<Integer> ans = new Vector<>();
        for(int i = n-1;i>=0;i--){

            while(val >= deno[i]){
                val-=deno[i];
                ans.add(deno[i]);
            }
        }

        for(int i = 0;i<ans.size();i++){
            System.out.print(" " + ans.elementAt(i));
        }
    }

    public static void main(String[] args) {
        int n = 93;
        System.out.print(
            "Following is minimal number "
            +"of change for " + n + ": ");
        findMin(n);
    }
}

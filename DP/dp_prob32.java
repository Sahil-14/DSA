// count the number of bst for n keys
// hint use catalin number

/**
 * 
 * The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42,
 * 132, 429, 1430, 4862
 * 
 */
public class dp_prob32 {
    public int countTrees(int n) {
        int T[] = new int[n + 1];
        T[0] = 1;
        T[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                T[i] += T[j] * T[i - j - 1];
            }
        }
        return T[n];
    }

    public static void main(String[] args) {
        dp_prob32 ob = new dp_prob32();
        System.out.println(ob.countTrees(5));
    }
}

/**
 * Maximum Length Chain of Pairs
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number. A pair (c, d) can follow another pair (a, b)
 * if b < c. Chain of pairs can be formed in this fashion. Find the longest
 * chain which can be formed from a given set of pairs.
 * Source: Amazon Interview | Set 2
 * For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40},
 * {50, 90} }, then the longest chain that can be formed is of length 3, and the
 * chain is {{5, 24}, {27, 40}, {50, 90}}
 * 
 * This problem is a variation of standard Longest Increasing Subsequence
 * problem. Following is a simple two step process.
 * 1) Sort given pairs in increasing order of first (or smaller) element. Why do
 * not need sorting? Consider the example {{6, 8}, {3, 4}} to understand the
 * need of sorting. If we proceed to second step without sorting, we get output
 * as 1. But the correct output is 2.
 * 2) Now run a modified LIS process where we compare the second element of
 * already finalized LIS with the first element of new LIS being constructed.
 * The following code is a slight modification of method 2 o
 */

public class prob12_grdy {
  // method 1
  int a;
  int b;

  public prob12_grdy(int a, int b) {
    this.a = a;
    this.b = b;
  }

  static int maxChainLength(prob12_grdy arr[], int n) {
    int i, j, max = 0;
    int mcl[] = new int[n];
    /*
     * Initialize MCL (max chain length)
     * values for all indexes
     */
    for (i = 0; i < n; i++)
      mcl[i] = 1;

    for (i = 1; i < n; i++) {
      for (j = 0; j < i; j++) {
        if (arr[i].a > arr[j].b && (mcl[i] < mcl[j] + 1)) {
          mcl[i] = mcl[j] + 1;

        }
      }
      max = Math.max(max, mcl[i]);
    }
    return max;
  }

  public static void main(String[] args) {
    prob12_grdy arr[] = new prob12_grdy[] {
        new prob12_grdy(5, 24),
        new prob12_grdy(15, 25),
        new prob12_grdy(27, 40),
        new prob12_grdy(50, 60) };
    System.out.println("Length of maximum size chain is " + maxChainLength(arr, arr.length));
  }

  // method 2
  /**
   * 
   * static class val
   * {
   * int first;
   * int second;
   * };
   * 
   * static class pair
   * {
   * int first, second;
   * 
   * public pair(int first, int second)
   * {
   * this.first = first;
   * this.second = second;
   * }
   * 
   * @Override
   *           public int hashCode()
   *           {
   *           final int prime = 31;
   *           int result = 1;
   *           result = prime * result + first;
   *           result = prime * result + second;
   *           return result;
   *           }
   * 
   * @Override
   *           public boolean equals(Object obj)
   *           {
   *           if (this == obj)
   *           return true;
   *           if (obj == null)
   *           return false;
   *           if (getClass() != obj.getClass())
   *           return false;
   * 
   *           pair other = (pair) obj;
   *           if (first != other.first)
   *           return false;
   *           if (second != other.second)
   *           return false;
   * 
   *           return true;
   *           }
   * 
   *           }
   * 
   *           static Map<pair, Integer> m = new HashMap<>();
   * 
   *           // Memoisation function
   *           static int findMaxChainLen(val p[], int n,
   *           int prev, int pos)
   *           {
   * 
   *           // Check if pair { pos, prev } exists
   *           // in m
   *           if (m.containsKey(new pair(pos, prev)))
   *           {
   *           return m.get(new pair(pos, prev));
   *           }
   * 
   *           // Check if pos is >=n
   *           if (pos >= n)
   *           return 0;
   * 
   *           // Check if p[pos].first is
   *           // less than prev
   *           if (p[pos].first <= prev)
   *           {
   *           return findMaxChainLen(p, n, prev,
   *           pos + 1);
   *           }
   * 
   *           else
   *           {
   *           int ans = Math.max(findMaxChainLen(
   *           p, n, p[pos].second, 0) + 1,
   *           findMaxChainLen(
   *           p, n, prev, pos + 1));
   * 
   *           m.put(new pair(pos, prev), ans);
   *           return ans;
   *           }
   *           }
   * 
   *           // Function to calculate maximum
   *           // chain length
   *           static int maxChainLen(val p[], int n)
   *           {
   *           m.clear();
   * 
   *           // Call memoisation function
   *           int ans = findMaxChainLen(p, n, 0, 0);
   *           return ans;
   *           }
   * 
   *           // Driver Code
   *           public static void main(String[] args)
   *           {
   *           int n = 5;
   *           val []p = new val[n];
   *           for(int i = 0; i < n; i++)
   *           p[i] = new val();
   * 
   *           p[0].first = 5;
   *           p[0].second = 24;
   * 
   *           p[1].first = 39;
   *           p[1].second = 60;
   * 
   *           p[2].first = 15;
   *           p[2].second = 28;
   * 
   *           p[3].first = 27;
   *           p[3].second = 40;
   * 
   *           p[4].first = 50;
   *           p[4].second = 90;
   * 
   *           // Function Call
   *           System.out.print(maxChainLen(p, n) + "\n");
   *           }
   * 
   */

}

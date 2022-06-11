import java.util.PriorityQueue;

/**
 * K maximum sum combinations from two arrays
 * 
 * 
 */

public class prob18 {
  // method 1:
  // function to display first K
  // maximum sum combinations
  static void KMaxCombinations(int A[], int B[],
      int N, int K) {
    // max heap.
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
        Collections.reverseOrder());

    // Insert all the possible
    // combinations in max heap.
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        pq.add(A[i] + B[j]);

    int count = 0;

    while (count < K) {
      System.out.println(pq.peek());
      pq.remove();
      count++;
    }

  }

  // Driver Code
  public static void main(String[] args) {
    int A[] = { 4, 2, 5, 1 };
    int B[] = { 8, 0, 5, 3 };
    int N = A.length;
    int K = 3;

    // Function Call
    KMaxCombinations(A, B, N, K);
  }

  // method 2:

  public static class Pair {

    public Pair(int l, int m) {
      this.l = l;
      this.m = m;
    }

    int l;
    int m;

    @Override
    public boolean equals(Object o) {
      if (o == null) {
        return false;
      }
      if (!(o instanceof Pair)) {
        return false;
      }
      Pair obj = (Pair) o;
      return (l == obj.l && m == obj.m);
    }

    @Override
    public int hashCode() {
      return Objects.hash(l, m);
    }
  }

  public static class PairSum
      implements Comparable<PairSum> {

    public PairSum(int sum, int l, int m) {
      this.sum = sum;
      this.l = l;
      this.m = m;
    }

    int sum;
    int l;
    int m;

    @Override
    public int compareTo(PairSum o) {
      return Integer.compare(o.sum, sum);
    }
  }

  public static void MaxPairSum(Integer[] A, Integer[] B, int N, int K) {
    // sort both arrays A and B
    Arrays.sort(A);
    Arrays.sort(B);
    // Max heap which contains Pair of
    // the format (sum, (i, j)) i and j are
    // the indices of the elements from
    // array A and array B which make up the sum.
    PriorityQueue<PairSum> sums = new PriorityQueue<PairSum>();

    // pairs is used to store the indices of
    // the Pair(i, j) we use pairs to make sure
    // the indices does not repeat inside max heap.
    HashSet<Pair> pairs = new HashSet<Pair>();

    // initialize the heap with the maximum sum
    // combination ie (A[N - 1] + B[N - 1])
    // and also push indices (N - 1, N - 1) along
    // with sum.
    int l = N - 1;
    int m = N - 1;
    pairs.add(new Pair(l, m));
    sums.add(new PairSum(A[l] + B[m], l, m));
    // iterate upto K
    for (int i = 0; i < k; i++) {
      PairSum max = sums.poll();
      System.out.println(max.sum);
      l = max.l - 1;
      m = max.m;

      // insert only if l and m are greater
      // than 0 and the pair (l, m) is
      // not already present inside set i.e.
      // no repeating pair should be
      // present inside the heap.
      if (l >= 0 && m >= 0
          && !pairs.contains(new Pair(l, m))) {
        sums.add(new PairSum(A[l]
            + B[m], l, m));
        pairs.add(new Pair(l, m));

      }

      l = max.l;
      m = max.m - 1;

      // insert only if l and m are
      // greater than 0 and
      // the pair (l, m) is not
      // already present inside
      // set i.e. no repeating pair
      // should be present
      // inside the heap.

      if (l >= 0 && m >= 0
          && !pairs.contains(new Pair(l, m))) {
        // insert (A[i1]+B[i2], (i1, i2))
        // in the heap
        sums.add(new PairSum(A[l]
            + B[m], l, m));
        pairs.add(new Pair(l, m));
      }

    }

    // Driver Code
    // public static void main(String[] args)
    // {
    // Integer A[] = { 1, 4, 2, 3 };
    // Integer B[] = { 2, 5, 1, 6 };
    // int N = A.length;
    // int K = 4;

    // // Function Call
    // MaxPairSum(A, B, N, K);
    // }
  }
}

import java.util.ArrayList;

// print all subset from 1 to n;
public class bit_prob_4 {
  public static void subset(int arr[], int n) {
    for (int i = 0; i < (1 << n); i++) {
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          System.out.print(arr[j] + "\t");
        }
      }
      System.out.println();
    }
  }

  static void printPowerSet(char[] set,
      int set_size) {

    /*
     * set_size of power set of a set
     * with set_size n is (2**n -1)
     */
    long pow_set_size = (long) Math.pow(2, set_size);
    int counter, j;

    /*
     * Run from counter 000..0 to
     * 111..1
     */
    for (counter = 0; counter < pow_set_size; counter++) {
      for (j = 0; j < set_size; j++) {
        /*
         * Check if jth bit in the
         * counter is set If set then
         * print jth element from set
         */
        if ((counter & (1 << j)) > 0)
          System.out.print(set[j]);
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4 };
    subset(arr, 4);
  }

}

  // backtracking solution

findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output, int index)
    {
      if(index == nums.size()){
        subset.add(output);
        return;
      }
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
        output.add(nums.get(index));
                findSubsets(subset, nums, new ArrayList<>(output), index + 1);
 }

 public static void main(String[] args) {

// Main List for storing all subsets
List<List<Integer>> subset = new ArrayList<>();

// Input ArrayList
ArrayList<Integer> input = new ArrayList<>();input.add(1);input.add(2);input.add(3);

findSubsets(subset, input, new ArrayList<>(), 0);
 
      // Comparator is used so that all subset get
      // sorted in ascending order of values
        Collections.sort(subset, (o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) == o2.get(i)){
                    continue;
                }else{
                    return o1.get(i) - o2.get(i);
                }
            }
            return 1;
        });
       
       
      // Printing Subset
      for(int i = 0; i < subset.size(); i++){
          for(int j = 0; j < subset.get(i).size(); j++){
              System.out.print(subset.get(i).get(j) + " ");
          }
          System.out.println();
      }
       
    }
}
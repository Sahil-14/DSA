//pring all subset

import java.util.*;

public class bt_prob7 {
  public static void findSubsets(List<List<Integer>> result, ArrayList<Integer> nums, ArrayList<Integer> output,
      int index) {
    if (index == nums.size()) {
      result.add(output);
      return;
    }

    // do not current element include
    findSubsets(result, nums, new ArrayList<>(output), index + 1);

    // include current element;
    output.add(nums.get(index));
    findSubsets(result, nums, new ArrayList<>(output), index + 1);

  }

  public static subsets()

  public static void main(String[] args) {

    // Main List for storing all subsets
    List<List<Integer>> subset = new ArrayList<>();

    // Input ArrayList
    ArrayList<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(3);

    findSubsets(subset, input, new ArrayList<>(), 0);

    // Comparator is used so that all subset get
    // sorted in ascending order of values
    Collections.sort(subset, (o1, o2) -> {
      int n = Math.min(o1.size(), o2.size());
      for (int i = 0; i < n; i++) {
        if (o1.get(i) == o2.get(i)) {
          continue;
        } else {
          return o1.get(i) - o2.get(i);
        }
      }
      return 1;
    });

    // Printing Subset
    for (int i = 0; i < subset.size(); i++) {
      for (int j = 0; j < subset.get(i).size(); j++) {
        System.out.print(subset.get(i).get(j) + " ");
      }
      System.out.println();
    }

  }
}

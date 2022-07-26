  // public static String findLargestNumber(List<Integer> nums) {
  //   // sort using a custom function object
  //   Collections.sort(nums, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));
  //   return nums.stream()
  //       .map(Object::toString)
  //       .collect(Collectors.joining(""));
  // }
  // // using int
  // public static String largestNumber(List<Integer> arr) {
  //   // finding number of digits in maximum element
  //   // present in array
  //   int n = Collections.max(arr).toString().length();
  //   ArrayList<ExtendedNum> en = new ArrayList<ExtendedNum>();
  //   for (int i = 0; i < arr.size(); i++)
  //     en.add(new ExtendedNum(arr.get(i),
  //         n));

  //   // sort based on modified value
  //   Collections.sort(en, (p1, p2) -> (int) (p2.modifiedValue - p1.modifiedValue));

  //   StringBuilder sb = new StringBuilder();
  //   for (int i = 0; i < en.size(); i++)
  //     sb.append(new StringBuilder(Long.toString(en.get(i).originalValue)));

  //   // To remove any zeroes at head.
  //   BigInteger bi = new BigInteger(sb.toString());

  //   return bi.toString();
  // }

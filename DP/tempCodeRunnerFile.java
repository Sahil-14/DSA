   for (int i = words.length - 1; i >= 0; i--) {
      minCost[i] = cost[i][words.length - 1];
      result[i] = words.length;
      for (int j = words.length - 1; j > i; j--) {
        if (cost[i][j - 1] == Integer.MAX_VALUE) {
          continue;
        }
        if (minCost[i] > minCost[j] + cost[i][j - 1]) {
          minCost[i] = minCost[j] + cost[i][j - 1];
          result[i] = j;
        }
      }
    }
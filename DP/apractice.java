public class apractice {
  class Result {
    int maxSum;
    int uppperBound;
    int lowerBount;
    int leftBount;
    int rightBount;
  }

  public Result maxSumReact(int mat[][]){
    int row = mat.length;
    int col = mat[0].co
  }

  class KadanesResult {
    int maxSum;
    int start;
    int end;

    KadanesResult(int maxSum, int start, int end) {
      this.maxSum = maxSum;
      this.start = start;
      this.end = end;
    }
  }

  public KadanesResult kadanes(int input[]) {
    int max = 0;
    int maxSofar = 0;
    int maxStart = -1;
    int maxEnd = -1;
    int currentStart = 0;
    for (int i = 0; i < input.length; i++) {
      maxSofar += input[i];
      if (maxSofar < 0) {
        maxSofar = 0;
        currentStart = i + i;
      }
      if (max < maxSofar) {
        max = maxSofar;
        maxStart = currentStart;
        maxEnd = i;
      }
    }
    return new KadanesResult(max, maxStart, maxEnd);
  }
}

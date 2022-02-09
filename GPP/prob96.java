import java.util.PriorityQueue;

//optimal file merge pattern
/**
 * Given n number of sorted files, the task is to find the minimum computations
 * done to reach the Optimal Merge Pattern. When two or more sorted files are to
 * be merged altogether to form a single file, the minimum computations are done
 * to reach this file are known as Optimal Merge
 */
public class prob96 {
    static int minComputation(int size,int files[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<size;i++){
            pq.add(files[i]);
        }
  
        int count = 0;
        while(pq.size() >1){
            int temp = pq.poll() + pq.poll();
            count += temp;
            pq.add(temp);
        }
        return count;
    }
    public static void main(String[] args)
    {
 
        // no of files
        int size = 6;
 
        // 6 files with their sizes
        int files[] = new int[] { 2, 3, 4, 5, 6, 7 };
       
        // total no of computations
        // do be done final answer
        System.out.println("Minimum Computations = "
                           + minComputation(size, files));
    }
}

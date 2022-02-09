import java.util.*;

//expedi 
/**
 * A group of cows grabbed a truck and ventured on an expedition deep into the
 * jungle. Being rather poor drivers, the cows unfortunately managed to run over
 * a rock and puncture the truck's fuel tank. The truck now leaks one unit of
 * fuel every unit of distance it travels.
 * 
 * To repair the truck, the cows need to drive to the nearest town (no more than
 * 1,000,000 units distant) down a long, winding road. On this road, between the
 * town and the current location of the truck, there are N (1 <= N <= 10,000)
 * fuel stops where the cows can stop to acquire additional fuel (1..100 units
 * at each stop).
 * 
 * The jungle is a dangerous place for humans and is especially dangerous for
 * cows. Therefore, the cows want to make the minimum possible number of stops
 * for fuel on the way to the town. Fortunately, the capacity of the fuel tank
 * on their truck is so large that there is effectively no limit to the amount
 * of fuel it can hold. The truck is currently L units away from the town and
 * has P units of fuel (1 <= P <= 1,000,000).
 * 
 * Input Initial distance of truck from village Initial fual Number of fual
 * tanks and their distance t= test cases n = total fual stop l = initial
 * distance of truck from town, p = initial fual
 */
class Tank {
    int distance;
    int capacity;

    Tank(int distance, int capacity) {
        this.distance = distance;
        this.capacity = capacity;
    }

    // Getter
    public int getDistance() {
        return distance;
    }

    // Setter
    public void setDistance(int distance) {
        this.distance = distance;
    }
}

public class prob97 {

    static int minStop(int t, int n, Tank arr[], int l, int p) {
        int ans = 0;
        // while (t > 0) {
        // set distance from truck
        for (int i = 0; i < n; i++) {
            int tempDist = arr[i].getDistance();
            arr[i].setDistance(l - tempDist);
        }

        // sort array based on the initial distance of truck
        Arrays.sort(arr, new Comparator<Tank>() {
            @Override
            public int compare(Tank t1, Tank t2) {
                return t1.distance - t2.distance;
            }
        });
        

        int currCapacity = p;
        // maxheap to store ans
        PriorityQueue<Integer> mh = new PriorityQueue<Integer>(Collections.reverseOrder());
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            // if inital fual is more than total distance
            if (currCapacity >= l) {
                break;
            }
            // if tank is empty or not have enough fual
            while (currCapacity < arr[i].distance) {
                if (mh.isEmpty()) {
                    flag = true;
                    break;
                }
                ans++;
                currCapacity += mh.peek();
                mh.poll();
            }

            if (flag) {
                break;
            }
            mh.add(arr[i].capacity);
        }

        if (flag) {
            ans = -1;
            // continue;
        }
        // after reaching last stop if maxheap top is < remaining distance
        while (!mh.isEmpty() && currCapacity < l) {
            currCapacity += mh.peek();
            mh.poll();
            ans++;
        }
        // unable to reach destination
        if (currCapacity < l) {
            System.out.print(currCapacity);
            ans = -1;
            // break;
        }
        // t--;
        // }

        return ans;
    }

    public static void main(String[] args) {
        Tank arr[] = new Tank[4];
        int dist[] = { 4, 5, 11, 15 };
        int capa[] = { 4, 2, 5, 10 };
        for (int i = 0; i < dist.length; i++) {
            arr[i] = new Tank(dist[i], capa[i]);
        }
        
        System.out.print(minStop(1, 4, arr, 25, 10));

    }
}

// similar
// Number of refills to complete the journey of N km

/**
 * Given a number N which represents the total distance in km to be covered by a
 * car on a single road. There are N petrol pumps at a distance of 1 km each(1,
 * 2, 3, ..N). The capacity of the fuel tank of the car is such that at full
 * tank it goes till a distance of K km. The car has to compulsorily stop at M
 * petrol tanks whose distance from the starting position is given as M
 * integers. The task is to find the number of times, the car has to refill its
 * tank including the compulsory stops to complete its journey of N km.
 */

// class refill {
// static int countRefill(int N, int k, int M, int compulsory[]) {
// int count = 0;// to count refills
// int i = 0; // for coumpolsory array
// int distCovered = 0;

// while (distCovered < N) {
// // check for cumporsory
// if (i < M && compulsory[i] <= distCovered + k) {
// distCovered = compulsory[i];
// i++;
// } else {
// distCovered += k;
// }

// if (distCovered < N) {
// count++;
// }
// }
// return count;
// }

// public static void main(String[] args) {
// int N = 10;
// int K = 2;
// int M = 3;
// // compulsory petrol
// // pumps to refill at
// int compulsory[] = { 6, 7, 8 };
// }
// }
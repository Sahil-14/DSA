
// Box statcking problem
/**
 * 
 * Given different dimensions and unlimited supply of boxes for each
 * dimension, stack boxes
 * on top of each other such that it has maximum height but with caveat
 * that length and width
 * of box on top should be strictly less than length and width of box
 * under it. You can
 * rotate boxes as you like.
 * 
 * 1) Create all rotations of boxes such that length is always greater
 * or equal to width
 * 2) Sort boxes by base area in non increasing order (length * width).
 * This is because box
 * with more area will never ever go on top of box with less area.
 * 3) Take T[] and result[] array of same size as total boxes after all
 * rotations are done
 * 4) Apply longest increasing subsequence type of algorithm to get max
 * height.
 * 
 * If n number of dimensions are given total boxes after rotation will
 * be 3n.
 * So space complexity is O(n)
 * Time complexity - O(nlogn) to sort boxes. O(n^2) to apply DP on it So
 * really O(n^2)
 *
 * References
 * http://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/
 * http://people.cs.clemson.edu/~bcdean/dp_practice/
 */
import java.util.*;

class Dimension implements Comparable<Dimension> {
    int height;
    int length;
    int width;

    Dimension(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    Dimension() {
    }

    static Dimension CreateDimetion(int height, int side1, int side2) {
        Dimension d = new Dimension();
        d.height = height;
        if (side1 >= side2) {
            d.length = side1;
            d.width = side2;
        } else {
            d.length = side2;
            d.width = side1;
        }
        return d;
    }

    // sort in descending order
    @Override
    public int compareTo(Dimension d) {
        if (this.length * this.width >= d.length * d.width) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Dimention [height = " + height + ", length=" + length + " ,width=" + width + "]";
    }
}

public class dp_prob28 {
    public int maxHeight(Dimension[] input) {
        // get all rotations of box dimension.
        // e.g if dimension is 1,2,3 rotations will be 2,1,3 3,2,1 3,1,2 . Here length
        // is always greater
        // or equal to width and we can do that without loss of generality.
        Dimension[] allRotationInput = new Dimension[input.length * 3];
        createAllRotation(input, allRotationInput);

        // sort these boxes in non increasing order by their base area.(length X width)
        Arrays.sort(allRotationInput);

        // apply longest increasing subsequence kind of algorithm on these sorted boxes.
        int T[] = new int[allRotationInput.length];
        int result[] = new int[allRotationInput.length];

        for (int i = 0; i < T.length; i++) {
            T[i] = allRotationInput[i].height;
            result[i] = i;
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 0; j < i; j++) {
                if (allRotationInput[i].length < allRotationInput[j].length
                        && allRotationInput[i].width < allRotationInput[j].width) {
                    if (T[j] + allRotationInput[i].height > T[i]) {
                        T[i] = T[j] + allRotationInput[i].height;
                        result[i] = j;
                    }
                }
            }
        }

        // find max in T[] and that will be our max height.
        // Result can also be found using result[] array.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < T.length; i++) {
            if (T[i] > max) {
                max = T[i];
            }
        }

        return max;
    }

    // create all rotations of boxes, always keeping length greater or equal to
    // width
    public void createAllRotation(Dimension[] input, Dimension[] allRotationInput) {
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            allRotationInput[index++] = Dimension.CreateDimetion(input[i].height, input[i].width, input[i].length);
            allRotationInput[index++] = Dimension.CreateDimetion(input[i].width, input[i].height, input[i].length);
            allRotationInput[index++] = Dimension.CreateDimetion(input[i].length, input[i].height, input[i].width);
        }
    }

    public static void main(String[] args) {
        dp_prob28 ob = new dp_prob28();
        Dimension input[] = { new Dimension(3, 2, 5), new Dimension(1, 2, 4) };
        int maxHeight = ob.maxHeight(input);
        System.out.println(maxHeight);

    }
}

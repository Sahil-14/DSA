
import java.util.*;
// fractional knapsap
/**
 * The basic idea of the greedy approach is to calculate the ratio value/weight
 * for each item and sort the item on basis of this ratio. Then take the item
 * with the highest ratio and add them until we can’t add the next item as a
 * whole and at the end add the next item as much as we can. Which will always
 * be the optimal solution to this problem. A simple code with our own
 * comparison function can be written as follows, please see sort function more
 * closely, the third argument to sort function is our comparison function which
 * sorts the item according to value/weight ratio in non-decreasing order. After
 * sorting we need to loop over these items and add them in our knapsack
 * satisfying above-mentioned criteria.
 * 
 */
public class prob95 {
    static class ItemValue{
        Double cost;
        double wt,val,ind;

        public ItemValue(int wt,int val,int ind){
            this.wt = wt ;
            this.val = val;
            this.ind = ind;
            cost = new Double((double)val/(double)wt);
        }
    }

    static double getMaxValue(int wt[],int val[],int capacity){
        ItemValue ival[] = new ItemValue[wt.length];

        for(int i = 0;i<wt.length;i++){
            ival[i] = new ItemValue(wt[i], val[i], i);
        }

        //sort by value
        Arrays.sort(ival,new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue v1,ItemValue v2){
                return v2.cost.compareTo(v1.cost);
            }
        });

        double totalValue = 0d;

        for(ItemValue i: ival){
            int curWt = (int)i.wt;
            int curVal = (int)i.val;

            if(capacity - curWt >=0){
                //whole weight can be picked;
                capacity -=curWt;
                totalValue+=curVal;
            }else{
                //whole wight can't be picked
                double fraction = (double)capacity / (double)curWt;
                totalValue += (curVal * fraction);
                capacity = (int)(capacity - (curWt*fraction));
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args)
    {
        int[] wt = { 10, 40, 20, 30 };
        int[] val = { 60, 40, 100, 120 };
        int capacity = 50;
  
        double maxValue = getMaxValue(wt, val, capacity);
  
        // Function call
        System.out.println("Maximum value we can obtain = "
                           + maxValue);
    }
}

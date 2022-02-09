import java.util.Vector;
import java.util.*;

public class prob23 {
    static Vector<Vector<Integer>> ans;
    static void swap(int a,int b,Vector<Integer> arr){
        int temp = arr.get(a);
        arr.set(a, b);
        arr.set(b,temp);

    }
    //given an array of distinct nuber find all possible permutation
    static void permute(Vector<Integer> a,int idx){
        if(idx == a.size()){
            ans.add(a);
            return ;
        }
        for(int i = idx;i<a.size();i++){
            swap(i, idx, a);
            permute(a, idx+1);
            swap(i, idx, a);
        }
        return ;
    }
    public static void main(String arg[]){
        
        Vector<Integer> a = new Vector<>(3);
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        for(int i = 0;i<3;i++){
            a.set(i, sc.nextInt());
        }
        permute(a, 0);
        for(int i = 0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}

import java.util.Stack;

// Trapping Rainwater Harvesting
/**
 * Given non-nagative intergers representing on elavtion map where the width of
 * each bar is 1 compute how mucvh water it can trap after raining
 * 
 */
public class prob47 {
static int trappingWaterArea(int arr[],int n){
    Stack<Integer> s = new Stack<>();
    int ans = 0;
    for(int i = 0;i<n;i++){
        while(!s.isEmpty() && arr[s.peek()] < arr[i]){
            int curr = s.peek();
            s.pop();
            if(s.isEmpty()){
                break;
            }
            int diff = i -s.peek() -1;
            ans+=  (Math.min(arr[s.peek()], arr[i]) - arr[curr])*diff;
        }
        s.push(i);
       
    }
    return ans;
}
public static void main(String[] args) {
    int arr[] = {7,5,4,3,6};
    System.out.println(trappingWaterArea(arr,5));
}
}

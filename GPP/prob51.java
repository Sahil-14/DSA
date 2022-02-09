/**
 * Max consecutive ones
 * given ans array oa of 0 and 1 mwe may change up to ka values from 0 to1
 * return the length of the longest continues subarray that contains only 1s
 * 
 * Input = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * output 6;
 * [1,1,1,0,0,1,1,1,1,1,1]
 */
public class prob51 {
    static int maxConsZero(int a[],int n,int k){
        int zerocount = 0,i = 0,ans = 0;
        for(int j = 0;j <n;j++){
            if(a[j] == 0){
                zerocount++;
            }
            while(zerocount >k){
                if(a[i] == 0){
                    zerocount--;
                }
                i++;
            }
            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int a[] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(maxConsZero(a, a.length, 2));

    }
}

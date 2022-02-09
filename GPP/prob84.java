import java.util.*;
// check whether subarray of length k is palindrome or not
public class prob84 {
    static boolean isPalindrome(int num){
        int temp=num,reverse =0;
        while(temp > 0){
            reverse = reverse*10 + temp%10;
            temp = temp/10;
        }
        if(num == reverse){
            return true;
        }
        return false;
    }
    static int palindromeSubarrray(Vector<Integer> arr,int k){
        int num =0;
        for(int i = 0;i<k;i++){
            num = num*10 + arr.get(i);
        }
        if(isPalindrome(num)){
            return 0;
        }
        for(int j = k;j<arr.size();j++){
            num = arr.get(j) + (num % (int)Math.pow(10, k-1))*10;
            if(isPalindrome(num)){
                return j-k+1;
            }
            System.out.println(2351%1000);
        }
        return -1;
    }
    public static void main(String[] args) {
        Vector<Integer> arr= new Vector<>();
        arr.add(2);
        arr.add(3);
        arr.add(5);
        arr.add(1);
        arr.add(1);
        arr.add(5);
        int ans = palindromeSubarrray(arr, 4);
        System.out.println(ans);
    }
}

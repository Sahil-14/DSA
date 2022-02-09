public class apractice {
  public int reverse(int n){
      int reverseNumber = 0;
      int remainder = 0;
      while(n > 0){
        remainder = n%10;
        reverseNumber = reverseNumber*10+remainder;
        n = n/10;
      }
      return reverseNumber;
  }

  public int fibo(int n){
    int a = 0;
    int b = 1;
    for(int i = 1;i<=n;i++){
      int temp = b;
      b = a+b;
      a = b;
    }
    return b;
  }

  public int binarytoDec(int n){
    int ans = 0;
    int x = 1;
    while(n > 0){
      int r = n%2;
      ans += x*r;
      x*=2;
      n = n/10;
    }
    return ans;
  }

  public int hexToDec(String str){
    int ans = 0;
    int x = 16;
    for(int i = str.length()-1;i >=0;i--){
      if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
        ans += x* (str.charAt(i) - '0');
      }else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'F'){
        ans += x* (str.charAt(i) - 'A'+10);
      }
      x *= 16;
    }
  }

  public int las(int arr[]){
    int res = 2;
    int curr = 2;
    int j =2 ;
    int d = arr[1] - arr[0];
    while(j < arr.length){
      if(d == arr[j] -arr[j-1]){
        curr++;
      }else{
        d = arr[j] - arr[j-1];
        curr = 2;
      }
      res = Math.max(res,curr);
      j++;
    }
    return res;
  }

  public int recordBreakingDay(int arr[]){
    int res = 0;
    int max = Integer.MIN_VALUE;
    if(arr.length  <=1){
      return arr.length;
    }
   for(int i =0;i<arr.length;i++){
     if(arr[i] > max && arr[i] > arr[i+1]){
       res++;
     }
     max = Math.max(arr[i], max);
   }
  }
}

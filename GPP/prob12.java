// 1. find palindrome
// 2.  

public class prob12 {
    static boolean palindrom(char a[]){
        int l = a.length;
        for(int i = 0;i<l/2;i++){
            if(a[i] !=  a[l-i-1]){
                return false;
            }
        }
        return true;
    }
    // given a string s , find the lenght of largest word
    static int maxWordLength(String s){
        char a[] = s.toCharArray();
        System.out.println(a.length);
       
        int currleng = 0,maxleng =0;
     
       

        for(int i = 0;i<s.length();i++){
            if(a[i] == ' ' ){
                if(currleng > maxleng){
                    maxleng = currleng;
                }
                currleng = 0;
            }else{
                currleng++;
            }
           
        }
        if(currleng > maxleng){
            maxleng = currleng;
        }
        return maxleng;
    }
  

    public static void main(String arg[]){
        char a[] ={'n','o','t','i','n'};
        if(palindrom(a)){
            System.out.println("Yes");
        }else{
            System.out.println("No"); 
        }
        System.out.println(maxWordLength("Do or die"));
    }
}

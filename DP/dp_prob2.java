// Longest common subsequence  in string

class dp_prob2{
    //using recurrsion
    public int lcs(char str1[],char str2[],int len1,int len2){
        if(len1 == str1.length || len2 == str2.length){
            return 0;
        }
        if(str1[len1] == str2[len2]){
            return 1+ lcs(str1,str2,len1+1,len2+1);
        }else{
            return Math.max(lcs(str1, str2, len1+1, len2),lcs(str1, str2, len1, len2+1));
        }
    }

    public int lcsDynamic(char str1[],char str2[]){
        Scanner s = new Scanner(System.in);
    
        int temp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){
                if(str1[i-1] == str2[j-1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
        return max;
    
    }
    static int longestCommonSubsequence(String s1,String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int k[][] = new int[l1+1][l2+1];
        for(int i = 0;i<=l1;i++){
            for(int j = 0;j<=l2;j++){
                if(i == 0 || j == 0){
                    k[i][j] = 0;
                }

                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    k[i][j] = k[i-1][j-1]+1;
                }else{
                    k[i][j] = Math.max(k[i][j-1], k[i-1][j]);
                }
            }
        }
        return k[l1][l2];
    }
    public static void main(String arg[]){
        String s1 = "abcdaf";
        String s2 = "acbcf";
        int l = longestCommonSubsequence(s1,s2);
        System.out.println(l);
    }
}
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
// ascii A = 65
// ascii 
public class prob13 {
    static StringBuffer toUpperCase(StringBuffer s){
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) >='a' && s.charAt(i) <= 'z'){
                s.setCharAt(i, (char)((int)s.charAt(i) -32));
                
            }
        }

        return s;
    }
    static StringBuffer toLowerCase(StringBuffer s){
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) >='A' && s.charAt(i) <= 'Z'){
                s.setCharAt(i, (char)((int)s.charAt(i) +32));
                
            }
        }

        return s;
    }
    static String sort(String s){
        char a[] = s.toCharArray();
        Arrays.sort(a);
        StringBuffer string = new StringBuffer(a);

    }
    public static void main(String arg[]){
       StringBuffer string = new StringBuffer("dfhgjksdgiu");
       System.out.println(toUpperCase(string));
    }
}

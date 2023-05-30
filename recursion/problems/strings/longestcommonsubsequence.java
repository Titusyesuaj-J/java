package recursion.problems.strings;

import java.util.Arrays;

public class longestcommonsubsequence {
    public static void main(String[] args) {
        System.out.println('a'+0);
       String a="abc";
       String b="def";
        //System.out.println(lcs(a,b));
    }
    public static int lcs( String a, String b){
        if(a.length()==0 || b.length()==0){
            return 0;
        }
        if(a.charAt(0)==b.charAt(0)){
            return 1+lcs(a.substring(1),b.substring(1));
        }
        else{
            return Math.max(lcs(a,b.substring(1)),lcs(a.substring(1),b));
        }
    }
}

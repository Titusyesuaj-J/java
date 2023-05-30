package recursion.problems.strings;

import java.util.HashMap;

public class interstringsdp {
    public static void main(String[] args) {
        String s1 = "", s2 = "", s3 = "";
        System.out.println(helper(s1,s2,s3));
    }

    public static Boolean helper(String a,String b,String c) {
        HashMap<String, Boolean> dp = new HashMap<>();
        int ap = 0;
        int bp = 0;
        int cp = 0;
        if (a.length() + b.length() != c.length()) {
            return false;
        } else {
            return inter(a, b, c, ap, bp, cp,dp);
        }
    }
    private static Boolean inter(String a,String b,String c,int ap,int bp,int cp,HashMap<String, Boolean> dp){

        String key=ap+"&"+bp+"&"+cp;

        if(!dp.containsKey(key)) {
            if (ap == a.length() && bp == b.length() && cp == c.length()) {
                dp.put(key,true);
            }
            else if ((ap != a.length() && (bp != b.length() && (a.charAt(ap) == c.charAt(cp) && (b.charAt(bp) == c.charAt(cp)))))) {
                Boolean left = inter(a, b, c, ap + 1, bp, cp + 1, dp);
                Boolean right = inter(a, b, c, ap, bp + 1, cp + 1, dp);
                dp.put(key,left || right);
            }
            else if ((ap != a.length()) && (a.charAt(ap) == c.charAt(cp))) {
                dp.put(key,inter(a, b, c, ap + 1, bp, cp + 1, dp)) ;
            }
            else if ((bp != b.length()) && (b.charAt(bp) == c.charAt(cp))) {
                dp.put(key,inter(a, b, c, ap, bp + 1, cp + 1, dp));
            }

            //if((ap != a.length() && a.charAt(ap)!=c.charAt(cp)) && (bp != b.length() && (b.charAt(bp)!=c.charAt(cp)))){
            else{
            dp.put(key,false) ;
            }
        }
        return dp.get(key);
    }
}

package recursion.problems.strings;


import java.util.HashMap;

public class longestpalindromicsubsequence {
    public static void main(String[] args) {
        String a="bbabcbcab";
        System.out.println(helper(a));
    }
    public static int helper(String s){
        HashMap<String,Integer> dp= new HashMap<>();
        return lps(s,0,s.length()-1,dp);
    }
    public static int lps(String a,int s,int e,HashMap<String,Integer> dp){
        String key=s+"$"+e;
        if(s==e){
            return 1;
        }
        if(s>e){
            return 0;
        }
        if(!dp.containsKey(key)) {
            if (a.charAt(s) == a.charAt(e)) {
                dp.put(key, 2 + lps(a, s + 1, e - 1,dp));
            } else {
                dp.put(key, Math.max(lps(a, s + 1, e,dp), lps(a, s, e - 1,dp)));
            }
        }
        return dp.get(key);
    }
}

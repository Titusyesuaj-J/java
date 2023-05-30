package recursion.problems.strings;

import java.util.HashMap;

//////////////////////wagner fischer algorithm///////////////////////////////
public class mineditdistance {
    public static void main(String[] args) {
        String a="horse";
        String b="ros";
        System.out.println(res(a,b));
    }
    public static int res(String s,String t){
        HashMap<String,Integer> dp= new HashMap<>();

        return helper(s,t,s.length(),t.length(),dp);
    }
    public static int helper(String a,String b,int ap,int bp,HashMap<String,Integer> dp){
        String key=ap+"%"+bp;
        ////////base condition//////////////////
        if ((ap == 0) && (bp == 0)) {
            return 0;
        }
        if((ap==0) || (bp==0)){
            return Math.max(ap,bp);
        }

        if(!dp.containsKey(key)) {
            if (a.charAt(ap-1) == b.charAt(bp-1)) {
                dp.put(key, helper(a, b, ap - 1, bp - 1, dp));
            }
            else {               ///Insert operation////  //////Remove operation//  ////////replace operation////
                dp.put(key, 1 + Math.min(helper(a, b, ap, bp - 1, dp), Math.min(helper(a, b, ap - 1, bp, dp),helper(a, b, ap - 1, bp - 1, dp))));
            }
        }
        return dp.get(key);
    }
}

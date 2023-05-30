package recursion.problems.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class wordbreak {
    public static void main(String[] args) {
        String s="aaaaaaa";
        List<String> wordDict=Arrays.asList("aaaa","aaa");
        HashMap<String,Boolean> dp = new HashMap<>();
        System.out.println(helper("",s,wordDict,dp));
    }
    public static Boolean helper(String a,String b, List<String> wordDict,HashMap<String,Boolean> dp) {
        String key=a;
        if (wordDict.contains(a) && b.length()==0){
            return true;
        }
        if (!wordDict.contains(a) && b.length()==0){
            return false;
        }
        if(!dp.containsKey(key)) {
            if (wordDict.contains(a)) {
                      /////////////////accept//////////////////          /////////new start////////////////////
                dp.put(key,helper(a+b.charAt(0),b.substring(1), wordDict, dp) || helper(b.substring(0,1),b.substring(1), wordDict,dp));
            } else {
                return helper(a+b.charAt(0),b.substring(1), wordDict, dp);
            }
        }
        return dp.get(key);
    }
}

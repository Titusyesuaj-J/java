package recursion.problems.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class countdistinctsubsequences {
    public static void main(String[] args) {
        String a = "";
        String b = "ggg";
        HashMap<String, String> dp = new HashMap<>();
        System.out.println(perm(a, b, dp,0));
        //String k=""+"&"+"";

    }

    public static int perm(String a, String b, HashMap<String, String> dp,int count) {
        String key = a+"&"+b;
        if (!dp.containsKey(key)) {
            if (b.isEmpty()) {
                dp.put(key, a);
                count=count+1;
                return count;
            }
        }
        if (dp.containsKey(key)){
            return count;
        }
           return perm(a + b.charAt(0), b.substring(1),dp,count)+perm(a, b.substring(1),dp,count);
    }
}

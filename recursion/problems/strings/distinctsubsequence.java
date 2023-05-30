package recursion.problems.strings;

import java.util.HashMap;

public class distinctsubsequence {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        System.out.println(helper(s, t));
    }

    public static int helper(String s, String t) {
        HashMap<String, Integer> dp = new HashMap<>();
        return ds(s, t, 0, 0, dp);
    }

    private static int ds(String a, String b, int ap, int bp, HashMap<String, Integer> dp) {

        String key = ap + "$" + bp;
        if (ap == a.length() && bp == b.length()) {
            return 1;
        }
        if (ap == a.length()) {
            return 0;
        }
        if (bp == b.length()) {
            return 1;
        }
        if (!dp.containsKey(key)) {
            if (a.charAt(ap) != b.charAt(bp)) {
                dp.put(key, ds(a, b, ap + 1, bp, dp));
            } else {
                dp.put(key, ds(a, b, ap + 1, bp, dp) + ds(a, b, ap + 1, bp + 1, dp));
            }
        }
        return dp.get(key);
    }
}

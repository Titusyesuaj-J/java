package recursion.problems.strings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class permutation {
    public static void main(String[] args) {
        String x = "";
        String y = "abc";
        perm(x, y);

    }

    // print permutations!!!!
    public static void perm(String x, String y) {

        if (y.isEmpty()) {
            System.out.println(x);
            return;
        }
        if (x.isEmpty()) {
            String c = String.valueOf(y.charAt(0));
            perm(c, y.substring(1));
        } else {
            char c = y.charAt(0);
            for (int i = 0; i < x.length() + 1; i++) {
                perm(x.substring(0, i) + c + x.substring(i), y.substring(1));
            }
        }
    }

    // print list of permutations!!!!
    public static ArrayList<String> permu(String x, String y) {

        if (y.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(x);
            return list;
        }
        char c = y.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < x.length() + 1; i++) {
            ans.addAll(permu(x.substring(0, i) + c + x.substring(i), y.substring(1)));
        }
        return ans;
    }

    //count number of permutations!!!1
    public static Integer count(String x, String y) {

        if (y.isEmpty()) {
            return 1;
        }

        Integer res = 0;
        char c = y.charAt(0);
        for (int i = 0; i < x.length() + 1; i++) {
            Integer count = (count(x.substring(0, i) + c + x.substring(i), y.substring(1)));
            res = res + count;
        }
        return res;
    }
}





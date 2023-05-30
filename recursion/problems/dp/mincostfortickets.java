package recursion.problems.dp;

import java.util.HashMap;

public class mincostfortickets {
    public static void main(String[] args) {
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        System.out.println(mincostTickets(days,costs));
    }
    public static int mincostTickets(int[] days, int[] costs) {
        HashMap<String,Integer> dp= new HashMap<>();
        return sol(days,costs,0,0,dp);
    }

    private static int sol(int[] a,int[] b,int ap,int check,HashMap<String,Integer> dp){
        String key=ap+"%"+check;
        if(ap==a.length) {
            return 0;
        }
        if(!dp.containsKey(key)) {
            if (a[ap] < check) {
                dp.put(key,sol(a, b, ap + 1, check, dp));
            } else {
                dp.put(key,Math.min(b[0] + sol(a, b, ap, a[ap] + 1, dp), Math.min(b[1] + sol(a, b, ap, a[ap] + 7, dp), b[2] + sol(a, b, ap, a[ap] + 30, dp))));
            }
        }
        return dp.get(key);
    }

}

package recursion.problems.dp;

import java.util.HashMap;

public class mincostclimbingstairs {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int n=0;
        HashMap<String,Integer> dp=new HashMap<>();
        System.out.println(minCostClimbingStairs(cost,n,dp));
    }
    public static int minCostClimbingStairs(int[] cost, int n, HashMap<String,Integer> dp) {
        String key=n+"&";
        if(n>=cost.length){
            return 0;
        }
        if(!dp.containsKey(key)) {
            dp.put(key, Math.min(cost[n] + minCostClimbingStairs(cost, n + 1, dp), cost[n] + minCostClimbingStairs(cost, n + 2, dp)));
        }
        if(key.equals(0+"&")){
            int first=dp.get(key);
            int second=dp.get(1+"&");
            return Math.min(first,second);
        }
        else {
            return dp.get(key);
        }
    }
}

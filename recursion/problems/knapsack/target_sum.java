package recursion.problems.knapsack;

import java.util.HashMap;

public class target_sum {
    public static void main(String[] args) {
        int[] arr = {1};
        int sum = 1;
        System.out.println(t_sum(arr, sum));

    }

    public static int t_sum(int[] arr, int sum) {
        int s = 0;
        int n = 0;
        HashMap<String,Integer> dp=new HashMap<>();
        return helper(arr, n, s, sum,dp);
    }

    private static int helper(int[] arr, int n, int s, int sum,HashMap<String,Integer>dp) {

        if (n == arr.length) {
            if(s==sum){
                return 1;
            }
            else{
                return 0;
            }
        }
        String key=n+"&"+s;
        if(!dp.containsKey(key)){
            dp.put(key,helper(arr, n + 1, s + 1, sum,dp)+helper(arr, n + 1, s - 1, sum,dp));
        }
        return dp.get(key);
    }
}


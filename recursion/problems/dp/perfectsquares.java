package recursion.problems.dp;

import java.util.Arrays;
import java.util.HashMap;

public class perfectsquares {
    public static void main(String[] args) {
        System.out.println(helper(13));
    }
    public static int helper(int n) {
        int k = (int) (Math.sqrt(n));
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = ((int) Math.pow(i + 1, 2));
        }
        HashMap<String, Integer> dp = new HashMap<>();
        return numSquares(arr,0,n,dp);
    }

    public static int numSquares(int[] arr,int n,int sum, HashMap<String,Integer> dp) {
        String key = n + "&" + sum;
        if (sum == 0) {
            return 0;
        }
        if ((n == arr.length) || (sum < 0)) {
            return (int) Math.pow(10, 6);
        }
        if (!dp.containsKey(key)) {
            dp.put(key, Math.min(1 + numSquares(arr, n, sum - arr[n], dp), numSquares(arr, n + 1, sum, dp)));
        }
        return dp.get(key);
    }
}

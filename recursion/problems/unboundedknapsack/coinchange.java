package recursion.problems.unboundedknapsack;
import java.util.HashMap;

import static java.lang.Math.min;
public class coinchange {
    public static void main(String[] args) {
        int[] arr={2};
        int amount=3;

        System.out.println(coin(amount,arr));
        //System.out.println(Integer.MAX_VALUE);
    }
    //number of all possibilities///

    public static int coin(int sum,int arr[]){
        HashMap<String,Integer> dp=new HashMap<>();
        return coin2(arr,0,sum,dp);
    }
    private static int coin1(int[] arr, int n, int sum, HashMap<String,Integer> dp) {
        String key=n+"&"+sum;
        if (sum == 0) {
            return 1;
        }
        if (n == arr.length) {
            return 0;
        }
        if(!dp.containsKey(key)){
            if (arr[n] > sum) {
                dp.put(key,coin1(arr, n + 1, sum,dp));
            }
            else {
                dp.put(key,coin1(arr, n, sum - arr[n],dp)+ coin1(arr, n + 1, sum,dp));
            }
        }
        return dp.get(key);
    }
    //count the minimum / steps possibility to attain required sum///

    public static int coin2(int[] arr,int n,int sum,HashMap<String,Integer> dp) {
        String key = n + "&" + sum;
        if (sum == 0) {
            return 0;
        }
        if ((n == arr.length) || (sum < 0)) {
            return (int) Math.pow(10, 6);
        }
        if(!dp.containsKey(key)){
            dp.put(key,Math.min(1 + coin2(arr, n, sum - arr[n], dp), coin2(arr, n + 1, sum, dp)));
        }
        return dp.get(key);
    }
}


package recursion.problems.unboundedknapsack;

import java.util.HashMap;

import static java.lang.Math.max;

public class rodcutting {
    public static void main(String[] args) {
        //int arr[]={3, 5, 8, 9, 10, 17, 17, 20};
      //  int n=arr.length;
       // System.out.println(rodcutting(arr,n));
        System.out.println((int)Math.pow(10,6)+20);
    }
    public static int rodcutting(int[] arr,int n){
        HashMap<String,Integer> dp = new HashMap<>();
        return helper(arr,1,n,dp);
    }
    private static int helper(int[] arr,int n,int s,HashMap<String,Integer> dp){
        String key=n+"&"+s;
        if(n==arr.length+1){
            return 0;
        }
        if(s==0){
            return 0;



        }
        if(!dp.containsKey(key)) {
            if (n > s) {
                dp.put(key,helper(arr, n + 1, s,dp));
            } else {
                dp.put(key,max(arr[n - 1] + helper(arr, n, s - n,dp), helper(arr, n + 1, s,dp)));
            }
        }
        return dp.get(key);
    }
}

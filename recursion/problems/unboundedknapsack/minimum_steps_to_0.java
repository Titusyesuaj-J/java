package recursion.problems.unboundedknapsack;

import java.util.HashMap;

import static java.lang.Math.min;

public class minimum_steps_to_0 {
    public static void main(String[] args) {
        int nums[]={1,1,4,2,3};
        int x=5;
        int ans=helper(nums,x);
        if(ans>=(int)Math.pow(10,6)){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }

    }
    public static int helper(int[] nums, int x){
        HashMap<String,Integer> dp=new HashMap<>();
        int left=0;
        int right= nums.length-1;
        return minimum(nums,left,right,x,dp);
    }
    public static int minimum(int[] arr,int left,int right,int sum,HashMap<String,Integer> dp){
        String key=left+"&"+right+"&"+sum;
        if(sum==0){
            return 0;
        }
        if ((left>right) || (sum<0)){
            return (int)Math.pow(10,6);
        }
        if(!dp.containsKey(key)) {
            dp.put(key,min((1 + minimum(arr, left + 1, right, sum - arr[left], dp)), 1 + minimum(arr, left, right - 1, sum - arr[right], dp)));
        }
        return dp.get(key);
    }
}

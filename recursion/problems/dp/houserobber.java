package recursion.problems.dp;
import java.util.Arrays;
import java.util.HashMap;
//////////////////////house robber 1 and house robber 2//////////////////////////
public class houserobber {
    public static void main(String[] args) {
        int[] arr={1,2,3,1};
        System.out.println(rob(arr));
    }
    public static int rob(int[] nums){
        HashMap<String,Integer> dp= new HashMap<>();
        HashMap<String,Integer> dp2= new HashMap<>();
        return Math.max(max(Arrays.copyOfRange(nums,1,nums.length),0,dp),max(Arrays.copyOfRange(nums,0,nums.length-1),0,dp2));
    }
    public static int max(int[] arr,int n,HashMap<String,Integer> dp){
        String key=n+"$";

        if(n>arr.length){
            return 0;
        }
        if(!dp.containsKey(key)) {
            dp.put(key,(Math.max(arr[n] + max(arr, n + 2,dp), max(arr, n + 1,dp))));
        }
        return dp.get(key);
    }


}

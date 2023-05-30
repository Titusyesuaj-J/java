package recursion.problems.knapsack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class part_subset {
    public static void main(String[] args) {
        int arr[]={1,2,3,5};
        System.out.println(canpartition(arr));
    }

    public static Boolean canpartition(int[] arr){
        int sum= Arrays.stream(arr).sum();
        sum=sum/2;
        if(sum%2!=0){
            return false;
        }
        else {
            return partitionsubset(arr, 0, sum); //////helper function
        }
    }
    static Map<String,Boolean> dp = new HashMap<>();

    /////helper function /////helper function /////helper function /////helper function 
    private static Boolean partitionsubset(int[] arr,int n,int sum){   /////helper function
        if(sum==0){
            return true;
        }
        if(sum<0){
            return false;
        }
        if(n==arr.length){
            return false;
        }
        String key=arr+"$"+sum;

        if(!dp.containsKey(key)) {
            dp.put(key, (partitionsubset(arr, n + 1, sum) || partitionsubset(arr, n + 1, sum - arr[n])));
        }
        return dp.get(key);
    }
}

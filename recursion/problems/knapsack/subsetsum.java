package recursion.problems.knapsack;

import java.util.*;

public class subsetsum {
    public static void main(String[] args) {
        int[] arr ={1,2,6};
        int sum=5;
        int n=arr.length;
        System.out.println(subsum(arr,n,sum));
    }

////////////////////For dp refer partition subset!!!!!!!!!!!!!11

    public static Boolean subsum(int[] arr,int n,int sum){
        if (sum==0){
            return true;
        }
        if (sum<0){
            return false;
        }
        if (n==0){
            return false;
        }

        //accept and reject
            return subsum(arr, n - 1, sum - arr[n - 1]) || subsum(arr, n - 1, sum);
    }
}

package recursion.problems.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class longestincreasingsubsequence {
    public static void main(String[] args) {
        int [] nums={3,10,7,40,80};
       // lcs2(nums);
        System.out.println(helper(nums));
    }
///////////////////////Dynamic programming recursion////////////////////////////////////////////////
    public static int helper(int[] nums){
        int i=0;
        int s=Integer.MIN_VALUE;
        HashMap<String,Integer> dp=new HashMap<>();
        return res(nums,i,s,dp);
    }
    private static int res(int[] arr,int i,int s,HashMap<String,Integer> dp) {
        String key = i + "&" + s;
        if (i > arr.length - 1) {
            return 0;
        }
        if (!dp.containsKey(key)) {
            if (arr[i] > s) {
                dp.put(key, Math.max(1 + res(arr, i + 1, arr[i], dp), res(arr, i + 1, s, dp)));
            } else {
                dp.put(key, res(arr, i + 1, s, dp));
            }
        }
        return dp.get(key);
    }

///////////////////////////////////using for loops/////////////////////////////////////////////////////////
    public static void lcs(int[] a){
        int res=0;
       int[] list = new int[a.length];
       Arrays.fill(list,1);
       for(int i=1;i<a.length;i++){
           for(int j=0;j<i;j++){
               if((a[i]>a[j])&&(list[i]<=list[j])){
                   list[i]=list[j]+1;
               }
           }
       }
       for(int k=0;k<list.length;k++){
           if(list[k]>res){
               res=list[k];
           }
       }
        System.out.println(res);
    }
    //////////////maximum sum increasing subsequence/////////////////////////
    public static void lcs2(int[] a){
        int res=0;
        int[] list = new int[a.length];
        for(int k=0;k<a.length;k++){
            list[k]=a[k];
        }
        for(int i=1;i<a.length;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j]){
                    list[i]=Math.max(list[j]+a[i],list[i]);
                }
            }
        }
        for(int k=0;k<list.length;k++){
            if(list[k]>res){
                res=list[k];
            }
        }
        System.out.println(res);
    }
}

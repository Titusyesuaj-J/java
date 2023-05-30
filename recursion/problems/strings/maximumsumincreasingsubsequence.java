package recursion.problems.strings;

import java.util.Arrays;
import java.util.HashMap;

public class maximumsumincreasingsubsequence {
    public static void main(String[] args) {
        int[] arr={1,100,3,2,6};
        int n=5;
        System.out.println(mslcs(arr));
    }
    /////////////dynamic recursion///////////////////////////////////////////////////
    public static int helper(int[] arr,int n){
        HashMap<String,Integer> dp= new HashMap<>();
        n=0;
        int s=Integer.MIN_VALUE;
        return msis(arr,n,s,dp);
    }
    private static int msis(int[] arr,int n,int s,HashMap<String,Integer> dp){
        String key=n+"$"+s;
        if(n==arr.length){
            return 0;
        }
        if(!dp.containsKey(key)) {
            if (arr[n] > s) {
                dp.put(key,Math.max(arr[n] + msis(arr, n + 1, arr[n],dp), msis(arr, n + 1, s,dp)));
            } else {
                dp.put(key,msis(arr, n + 1, s,dp));
            }
        }
        return dp.get(key);
    }

    //////////////////////for loops////////////////////////////

    public static int mslcs(int[] a){
        int res=0;
        int[] list = new int[a.length];
        for(int i=0;i<a.length;i++){
            list[i]=a[i];
        }
        for(int i=1;i<a.length;i++){
            for(int j=0;j<i;j++){
                if((a[i]>a[j])&&(list[i]<list[j]+a[i])){
                    list[i]=list[j]+a[i];
                }
            }
        }
        for(int k=0;k<list.length;k++){
            if(list[k]>res){
                res=list[k];
            }
        }
        return res;
    }
}

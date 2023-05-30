package recursion.problems.dp;

import java.util.HashMap;

public class stockcooldown {
    public static void main(String[] args) {
        int arr[] ={1,2,3,0,2};
        HashMap<String,Integer> dp= new HashMap<>();
        stockscool3(arr,0,-1,dp);
        System.out.println(dp);
    }
    public static int stockscool3(int [] arr,int n,int buy,HashMap<String,Integer> dp) {
        String key=n+"&"+buy;
        if (n >= arr.length) {
            return 0;
        }
        if(!dp.containsKey(key)) {
            //////////i am not holding anything either buy or skip to next one///////////////////////////
            if (buy == -1) { //////////////////////buyyyyyyy////////////         ///////////skip/////////////////
                dp.put(key, Math.max(stockscool3(arr, n + 1, arr[n], dp), stockscool3(arr, n + 1, buy, dp)));
            }
            ///////////i am holding stocks in my hand  either sell or carry ////////////////
            else {/////////////////////sellllllll//////////////////////////////                  ///////carry////////////////
                dp.put(key, Math.max(arr[n] - buy + stockscool3(arr, n + 2, -1, dp), stockscool3(arr, n + 1, buy, dp)));
            }
        }
        return dp.get(key);
    }
    public static int stockscool2(int[] arr,int n,int sum,int buy,HashMap<String,Integer> dp){
        String key=n+""+sum+""+buy;
        if(n>= arr.length){
            return sum;
        }
        if(!dp.containsKey(key)) {
            if (buy == -1) {     ////////////buy///////////////
                dp.put(key,Math.max(stockscool2(arr, n + 1, sum, arr[n], dp), stockscool2(arr, n + 1, sum, buy, dp)));
            } else {             /////////////sell///////////////
                dp.put(key, Math.max(stockscool2(arr, n + 2, sum + arr[n] - buy, -1, dp), stockscool2(arr, n + 1, sum, buy, dp)));
            }
        }
        return dp.get(key);
    }
    public static int stockscool(int [] arr,int n,int buy,int sum){
        if(n>=arr.length-1){
            return sum;
        }
        if (buy<arr[n]){
            return stockscool(arr,n+2,arr[n+2],sum+(arr[n]-buy));
        }
        if(arr[n+1]>arr[n]){
            return Math.max(stockscool(arr,n+3,arr[n+3],sum+(arr[n+1]-arr[n])),stockscool(arr,n+2,buy,sum));
        }
       else{
           return stockscool(arr,n+1,arr[n+1],sum);
        }
    }
}

package recursion.problems.dp;

import java.util.*;

public class climbingstairs {
    public static void main(String[] args) {
        String x="a";
      HashMap<Character,Integer> hm =new HashMap<>();
      for(int i=0;i<x.length();i++){
          if(hm.containsKey(x.charAt(i))){
              hm.put(x.charAt(i),hm.get(x.charAt(i))+1);
          }
          else{
              hm.put(x.charAt(i),0);
          }
      }
        ArrayList<Character> r=new ArrayList<>(hm.keySet());
      String t="";
        for(int i=0;i<r.size();i++){
            t=t+r.get(i)+hm.get(r.get(i));
        }
        System.out.println(t);
    }
    public static int climbStairs(int n) {
        HashMap<String,Integer> dp= new HashMap<>();
        return helper(n,dp);
    }
    private static int helper(int n,HashMap<String,Integer> dp){
        String key=n+"%";
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        if(!dp.containsKey(key)){
            dp.put(key,helper(n-1,dp)+helper(n-2,dp));
        }
        return dp.get(key);
    }
}

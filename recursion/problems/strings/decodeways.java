package recursion.problems.strings;

import java.util.HashMap;

public class decodeways {
    public static void main(String[] args) {
        String k="27";
        System.out.println(numDecodings(k));
        }
    public static int numDecodings(String s) {
        HashMap<String,Integer> dp= new HashMap<>();
        return decode(s,0,0,dp);
    }
    private static int decode(String s,int sp,int prev,HashMap<String,Integer> dp){
          String key=sp+"$"+prev;
      //  }
        if (sp==s.length() && Integer.parseInt(s.substring(prev,sp))<27){
            return 1;
        }
        if (sp==s.length() && Integer.parseInt(s.substring(prev,sp))>=27){
            return 0;
        }
        if (sp>s.length()){
            return 0;
        }
        if (s.charAt(sp)=='0'){
            return 0;
        }
        if(sp==0 && prev==0){
            return decode(s,sp+1,sp,dp) + decode(s,sp+2,sp,dp);
        }
        if(Integer.parseInt(s.substring(prev,sp))>=27){
            return 0;
        }
        if(!dp.containsKey(key)){
             dp.put (key,decode(s,sp+1,sp,dp) + decode(s,sp+2,sp,dp));
        }
        return dp.get(key);
    }
}

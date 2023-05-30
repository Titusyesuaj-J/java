package recursion.problems.dp;

import java.util.Arrays;
import java.util.HashMap;

public class stonegame {
    public static void main(String[] args) {
        int[] x = {-1,-2,-3};
        //int[]y=Arrays.copyOfRange(x,4,4);
       // System.out.println(Arrays.toString(y));
        HashMap<String,Integer> dp = new HashMap<>();
        System.out.println(stoneGameIII(0,x,dp));
    }

    public static int stoneGameIII(int n, int[] stoneValue,HashMap<String,Integer> dp) {
        String key= "";
        for(int i=0;i<stoneValue.length;i++){
            key=key+stoneValue[i]+"&";
        }
        if (stoneValue.length == 0) {
            return 0;
        }
        if (stoneValue.length == 1) {
            return stoneValue[0];
        }
        if(!dp.containsKey(key)) {
            if(stoneValue.length==2) {
                dp.put(key, Math.max(stoneValue[n] - stoneGameIII(n, Arrays.copyOfRange(stoneValue, 1, stoneValue.length), dp),(stoneValue[n] + stoneValue[n + 1]) - stoneGameIII(n, Arrays.copyOfRange(stoneValue, 2, stoneValue.length), dp)));
            }
            else{
                dp.put(key, Math.max(stoneValue[n] - stoneGameIII(n, Arrays.copyOfRange(stoneValue, 1, stoneValue.length), dp), Math.max(((stoneValue[n] + stoneValue[n + 1]) - stoneGameIII(n, Arrays.copyOfRange(stoneValue, 2, stoneValue.length), dp)), (stoneValue[n] + stoneValue[n + 1] + stoneValue[n + 2]) - stoneGameIII(n, Arrays.copyOfRange(stoneValue, 3, stoneValue.length), dp))));

            }
        }
        return dp.get(key);
    }
}

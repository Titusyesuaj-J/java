package recursion.problems.dp;

import java.util.HashMap;

public class uniquepaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }
    public static  int uniquePaths(int m, int n) {
        HashMap<String,Integer> dp= new HashMap<>();
        return helper(0,0,m,n,dp);
    }
    private static int helper(int x,int y,int m,int n,HashMap<String,Integer> dp){
        String key=x+"%"+y;
        if((x==m-1) && (y==n-1)){
            return 1;
        }
        if(x==1 && y==1){
            return 0;
        }
        if (x==m-1){
            return helper(x,y+1,m,n,dp);
        }
        if (y==n-1){
            return helper(x+1,y,m,n,dp);
        }
        if(!dp.containsKey(key)) {
            dp.put(key,helper(x, y + 1, m, n, dp) + helper(x + 1, y, m, n, dp));
        }
        return dp.get(key);
    }
}

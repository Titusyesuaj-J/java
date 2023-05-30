package recursion.problems.dp;

import java.util.Arrays;

public class jumpgame {
    public static void main(String[] args) {
        int[] arr={2,0};
        int[] min= new int[arr.length];
        Arrays.fill(min,1,arr.length,Integer.MAX_VALUE);
        //System.out.println(Arrays.toString(min));
        System.out.println(helper(arr,min));
    }
    public static int helper(int[] arr,int[] min){
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(j+arr[j]>=i && min[j]!=Integer.MAX_VALUE){
                    min[i]=Math.min(min[j]+1,min[i]);
                }
            }
        }
        return min[arr.length-1];
    }
}

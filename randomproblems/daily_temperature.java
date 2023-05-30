package randomproblems;

import java.util.Arrays;

public class daily_temperature {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] dummy=new int[temperatures.length];
        int max=temperatures[temperatures.length-1];
        dummy[temperatures.length-1]=temperatures[temperatures.length-1];
        for(int i=temperatures.length-2;i>=0;i--){
            if(temperatures[i]>temperatures[i+1]){
                if(temperatures[i]<max){
                    dummy[i]=max;
                }
                else{
                    dummy[i]=temperatures[i];
                }
            }
            else{
                dummy[i]=temperatures[i+1];
            }
            max=Math.max(max,temperatures[i]);
        }
        return dummy;
    }
}

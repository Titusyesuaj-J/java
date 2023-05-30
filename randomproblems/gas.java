package randomproblems;

import java.util.Arrays;

public class gas {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost ={3,4,5,1,2};
        Arrays.stream(gas).sum(); 
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int i=0;
        while(i<gas.length){
            if(gas[i]>cost[i]){
                int total=gas[i]-cost[i];
                int j=i+1;
                while(true){
                    j=j% gas.length;
                    if(j==i) {
                        return i;
                    }
                    total=total+gas[j]-cost[j];
                    if(total<0){
                        i=i+1;
                        //i=j+1;
                        break;
                    }
                    j++;
                }
            }
            else {
                i++;
            }
        }
        return -1;
    }
}

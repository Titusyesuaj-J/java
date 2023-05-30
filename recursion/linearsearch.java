package recursion;

import java.util.ArrayList;
import java.util.List;

public class linearsearch {
    public static int linearsearch(int[] arr,int index,int target){

        int size= arr.length;
        if (index==size){
            return -1;
        }
        else if(arr[index]==target){
            return index;
        }

        return linearsearch(arr,index+1,target);
    }

    public static List<Integer> res = new ArrayList<Integer>();
    public static List linearsearch2(int[] arr,int index,int target){
        int size=arr.length;
        if(index==size){
            return res;
        } else if (arr[index]==target) {
            res.add(index);
        }

        return linearsearch2(arr,index+1,target);
    }
}

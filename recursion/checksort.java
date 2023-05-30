package recursion;

public class checksort {
    public static Boolean sort(int[] arr,int index){

        if (index==(arr.length)-1){
            return true;
        }
        return arr[index]<arr[index+1] && sort(arr,index+1);
    }
}


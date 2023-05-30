package recursion.problems.dp;

public class kadensalogo {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(res(arr));
    }
    public static int res(int[] arr){
        int maximum_sum_so_far=Integer.MIN_VALUE;
        int maximum_ending_here=0;
        for(int i=0;i<arr.length;i++){
            maximum_ending_here=arr[i]+maximum_ending_here;
            if(arr[i]>=maximum_ending_here){
                maximum_ending_here=arr[i];
            }
            if(maximum_ending_here>maximum_sum_so_far){
                maximum_sum_so_far=maximum_ending_here;
            }
        }
        return maximum_sum_so_far;
    }
}

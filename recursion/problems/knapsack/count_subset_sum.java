package recursion.problems.knapsack;

public class count_subset_sum {

    public static void main(String[] args) {
        int arr[]={2,3,7,1,4,5};
        int n=0;
        int s=7;
        System.out.println(count(arr,n,s));
    }

    public static int count(int[] arr,int n,int sum){
        if(sum==0){
            return 1;
        }
        if(n==arr.length){
            return 0;
        }
        if (arr[n]>sum){
            return count(arr,n+1,sum);
        }

        return count(arr,n+1,sum)+count(arr,n+1,sum-arr[n]);
    }
}

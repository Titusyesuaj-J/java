package recursion.problems;

public class jump_recursion {
    public static void main(String[] args) {
        int[] nums={1,2,0,3};
        System.out.println(canJump(nums,0));
    }
    public static boolean canJump(int[] arr,int n){
        if(arr[0]==0){
            return false;
        }
        else {
            for (int i = 1; i < arr[n] + 1; i++) {
                if (arr[n] == 0) {
                    return false;
                }
                if (n == arr.length-1) {
                    return true;
                }
                Boolean res = canJump(arr, n + i);
                if (res == true) {
                    return true;
                }
            }
        }
        return false;
    }
}

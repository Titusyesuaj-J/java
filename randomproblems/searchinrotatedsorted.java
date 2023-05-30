package randomproblems;

import java.util.Arrays;

public class searchinrotatedsorted {
    public static void main(String[] args) {
        int[] nums = {5,1,2,3,4};
        String[] x={"apple","apps","app"};
        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
        //System.out.println(search(nums));
    }
    public static int search(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int m=(l+r)/2;
        while(l<=r){
            if((nums[l]>nums[m] && nums[r]>nums[m]) && nums[m]<nums[m-1] || (nums[l]==nums[m] && nums[r]==nums[m])){
                break;
            }
            else if(nums[l]==nums[m] && nums[r]<nums[m]){
                l=m+1;
            }
            else if(nums[l]==nums[m] && nums[r]>nums[m]){
                break;
            }
            else if(nums[l]<nums[m] && nums[r]>nums[m]){
                r=m-1;
            }
            else if(nums[l]<nums[m]){
                l=m+1;
            }
            else{
                r=m-1;
            }
            m=(l+r)/2;
        }
        return nums[m];
    }
}

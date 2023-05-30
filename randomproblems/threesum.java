package randomproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threesum {
    public static void main(String[] args) {
        int[] n={-1,0,1,2,-1,-4,-2,-3,3,0,4};
        Arrays.sort(n);
        System.out.println(threeSum(n));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        HashSet<List<Integer>> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]<0){
                    j=j+1;
                }
                else if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> sub=new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                    hs.add(sub);
                    j=j+1;
                }
                else{
                    k=k-1;
                }
            }
        }
        for(List<Integer> o:hs){
            res.add(o);
        }
        return res;
    }
}

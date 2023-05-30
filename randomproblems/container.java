package randomproblems;

public class container {
    public static void main(String[] args) {
        int[] height={1,1};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int res=0;
        int l=0;
        int r=height.length-1;
        while(l<r){
            int store=(r-l)*Math.min(height[l],height[r]);
            res=Math.max(res,store);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}

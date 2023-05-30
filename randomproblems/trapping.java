package randomproblems;

public class trapping {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int m=height[0];
        int s=0;
        for(int i=1;i< height.length;i++){
            if(m>height[i]){
                s=s+(m-height[i]);
            }
            m=Math.max(m,height[i]);
        }
        return s;
    }
}

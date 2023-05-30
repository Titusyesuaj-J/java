package recursion.problems.dp;

public class stock1 {
    public static void main(String[] args) {
        int[] prices = {1,2};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int max=0;
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<i;j++){
                if(prices[i]>prices[j]){
                    max=Math.max(max,prices[i]-prices[j]);
                }
            }
        }
        return max;
    }
}

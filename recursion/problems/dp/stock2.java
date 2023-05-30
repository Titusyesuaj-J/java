package recursion.problems.dp;

public class stock2 {
    public static void main(String[] args) {
        int[] prices = {2,1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int min=prices[0];
        int tp=0;
        for(int i=1;i<prices.length;i++){
            if (prices[i]<prices[i-1]) {
                tp = tp + prices[i - 1] - min;
                min = prices[i];
            }
        }
        tp=tp+prices[prices.length-1]-min;
        return tp;
    }
}

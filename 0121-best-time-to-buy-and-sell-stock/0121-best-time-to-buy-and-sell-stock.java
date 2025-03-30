class Solution {
    public int maxProfit(int[] prices) {
        Boolean t = true;;
        int profit = 0;

        for(int i = 0 , j = 1; j < prices.length;) {
            if(prices[i] < prices[j]) {
                int sale = prices[j] - prices[i];
                profit = Math.max(profit, sale);
            } else {
                i = j;
            }

            j++;
        }
        return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        if(prices.length == 1) return 0;
        for(int i = 0, j = 1; j < prices.length; j++) {
            if(prices[i] >= prices[j]) {
                i = j;
                continue;
            }

            maxPrice = Math.max(maxPrice, prices[j] - prices[i]);
        }

        return maxPrice;
    }
}
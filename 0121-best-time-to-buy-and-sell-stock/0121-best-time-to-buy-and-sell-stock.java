class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        boolean flag = false;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] > prices[i+1]) {
                continue;
            }

            flag = true;
            break;
        }

        if(!flag) {
            return 0;
        }

        for(int i = 0, j = i + 1; j < prices.length; j++) {
            if(prices[i + 1] < prices[i]) {
                i++;
                continue;
            }

            if(prices[j] > prices[i]) {
                profit = Math.max(profit, prices[j] - prices[i]);
            } else {
                i = j;
            }
        }

        return profit;
    }
}
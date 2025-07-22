class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }

        return Math.min(dp[n-1], dp[n-2]);

    }
}

/*
if length of cost = 4
                     0 
       1                         2  
    2      3                  3     4
  3.  4. 4.   5             4.  5
4.   5

*/
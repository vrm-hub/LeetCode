class Solution {
    int[][] dp;
    private int dfs(char[] w1, char[] w2, int w1Index, int w2Index) {
        if(w2Index >= w2.length) {
            if(w1Index < w1.length) return w1.length - w1Index;
            return 0;
        }

        if(w1Index >= w1.length && w2Index < w2.length) {
            return w2.length - w2Index;
        }

        if(dp[w1Index][w2Index] != -1) return dp[w1Index][w2Index];

        if(w1[w1Index] == w2[w2Index]) return dfs(w1, w2, w1Index + 1, w2Index + 1);

        int res = Integer.MAX_VALUE;

        for(int j = 0; j < 3; j++) {
            if(j == 0) res = Math.min(res, 1+ dfs(w1, w2, w1Index, w2Index + 1));
            else if(j == 1) res = Math.min(res,1+dfs(w1, w2, w1Index + 1, w2Index));
            else res = Math.min(res, 1+dfs(w1, w2, w1Index + 1, w2Index + 1));
        }

        dp[w1Index][w2Index] = res;

        return res;
    }
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);

        return dfs(w1, w2, 0, 0);
    }
}
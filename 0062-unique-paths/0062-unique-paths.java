class Solution {
    private static int[][] dirs = {{0, 1}, {1, 0}};
    int[][] dp;
    private int dfs(int m, int n, int r, int c) {
        if(r >= m || c >= n) {
            return 0;
        }

        if (r == m - 1 && c == n - 1) return 1;

        if(dp[r][c] != -1) return dp[r][c];

        int res = 0;

        for(int[] dir : dirs) {
            res += dfs(m, n, r + dir[0], c + dir[1]);
        }
        dp[r][c] = res;

        return res;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return dfs(m, n, 0, 0);
    }
}
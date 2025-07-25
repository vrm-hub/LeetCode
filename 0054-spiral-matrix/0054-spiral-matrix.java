class Solution {
    private static int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int count= 0;
        int total = n * m;
        boolean[][] visited = new boolean[n][m];
        int i = 0, j = 0;
        int d = 0;

        while(count < total) {
            if(j >= m || j < 0 || i < 0 || i >= n || visited[i][j]) {
                i = i - dirs[d][0];
                j = j - dirs[d][1];
                d++;
                if(d == 4) {
                    d = 0;
                }
                i = i + dirs[d][0];
                j = j + dirs[d][1];
            }
            res.add(matrix[i][j]);
            count++;
            visited[i][j] = true;
            i = i + dirs[d][0];
            j = j + dirs[d][1];
        }

        return res;
    }
}
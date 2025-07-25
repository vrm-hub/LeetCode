class Solution {
    private static int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private int r = 0, c = 0;
    private boolean[][] visited;
    private int count = 0;
    private int currDir = 0;

    private void resetDir() {
        r = r - dirs[currDir][0];
        c = c - dirs[currDir][1];
        currDir++;
        
        if(currDir == 4) {
            currDir = 0;
        }
        
        r = r + dirs[currDir][0];
        c = c + dirs[currDir][1];
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int total = n * m;
        visited = new boolean[n][m];

        while(count < total) {
            if(c >= m || c < 0 || r < 0 || r >= n || visited[r][c]) {
                resetDir();
            }
            res.add(matrix[r][c]);
            count++;
            visited[r][c] = true;
            r = r + dirs[currDir][0];
            c = c + dirs[currDir][1];
        }

        return res;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int freshCounter = 0;
        int counter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new Pair<>(i, j));
                }

                if(grid[i][j] == 1) freshCounter++; 
            }
        }

        if(freshCounter == 0) return 0;

        while(!q.isEmpty()) {
            int length = q.size();
            counter++;
            for(int k = 0; k < length; k++) {
                Pair<Integer, Integer> p = q.poll();
                int i = p.getKey();
                int j = p.getValue();
                if(j > 0 && grid[i][j-1] == 1) {
                    grid[i][j-1] = 2;
                    freshCounter--;
                    q.offer(new Pair<>(i, j-1));
                }
                if(j < grid[i].length - 1 && grid[i][j+1] == 1) {
                    grid[i][j+1] = 2;
                    freshCounter--;
                    q.offer(new Pair<>(i, j+1));
                }

                if(i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    freshCounter--;
                    q.offer(new Pair<>(i-1, j));
                }
                if(i < grid.length - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    freshCounter--;
                    q.offer(new Pair<>(i+1, j));
                }
            }
        }

        if(freshCounter != 0) {
            return -1;
        }

        return counter - 1;
    }
}
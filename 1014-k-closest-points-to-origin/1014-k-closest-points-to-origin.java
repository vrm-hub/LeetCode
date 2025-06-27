class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> b[2] - a[2]);
        for(int[] point : points) {
            int distance = (int)(point[0] * point[0] + point[1] * point[1]);
            maxHeap.offer(new int[]{point[0], point[1], distance});
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()) {
            int[] temp = maxHeap.poll();
            res[i][0] = temp[0];
            res[i][1] = temp[1];
            i++;
        }

        return res;
    }
}

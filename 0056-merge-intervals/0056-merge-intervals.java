class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> ls = new ArrayList<>();
        ls.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] temp = ls.getLast();
            if(intervals[i][0] > temp[1]) {
                ls.add(intervals[i]);
                continue;
            }

            ls.remove(ls.size() - 1);
            ls.add(new int[]{temp[0], Math.max(intervals[i][1], temp[1])});
        }

        return ls.toArray(new int[0][]);
    }
}
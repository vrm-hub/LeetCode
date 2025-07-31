class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(Map.Entry.comparingByValue());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            q.offer(m);
            while(q.size() > k) q.poll();
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[k - i - 1] = q.poll().getKey();
        }

        return res;
    }
}
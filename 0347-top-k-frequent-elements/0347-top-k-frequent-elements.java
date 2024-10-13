class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i], 1);
            } else {
                int freq = freqMap.get(nums[i]);
                freqMap.put(nums[i], freq + 1);
            }
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for(Map.Entry<Integer,Integer> set : freqMap.entrySet()) {
            buckets[set.getValue()].add(set.getKey());
        }

        int[] result = new int[k];
        for(int j=0, i = buckets.length - 1; i >= 0; i--) {
            for(Integer p : buckets[i]) {
                result[j] = p;
                j++;
                if(j == k) {
                    return result;
                }
            }
        }

        return result;

    }
}
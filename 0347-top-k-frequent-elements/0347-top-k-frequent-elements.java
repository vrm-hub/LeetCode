class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i], 1);
            } else {
                int freq = freqMap.get(nums[i]);
                freqMap.put(nums[i], freq + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> arrList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> set : freqMap.entrySet()) {
           arrList.add(set);
        }

        Collections.sort(arrList, (i1,i2) -> i1.getValue().compareTo(i2.getValue()));

        int[] arr = new int[k];
        int j = 0;
        for(int t = arrList.size() - 1; t >= 0; t--) {
            if(j < k){
                arr[j] = arrList.get(t).getKey();
                j++;
            }
        }

        return arr;
        
    }
}
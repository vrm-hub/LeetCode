class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> arrMapping = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            int comp = target - nums[i];
            if(!arrMapping.containsKey(comp)) {
                arrMapping.put(nums[i], i);
                continue;
            } else {
                return new int[]{i, arrMapping.get(comp)};
            }
        }

        return new int[2];
    }
}
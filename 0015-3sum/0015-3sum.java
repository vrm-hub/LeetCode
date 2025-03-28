class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1, k = nums.length - 1; j < k;) {
                int target = nums[i];
                if(target + nums[k] + nums[j] > 0) {
                    k--;
                } else if(target + nums[k] + nums[j] < 0) {
                    j++;
                } else {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    if(!set.contains(ls)) {
                        set.add(ls);
                    }
                    k--;
                    j++;
                }
            }
        }

        return new ArrayList<>(set);
    }
}

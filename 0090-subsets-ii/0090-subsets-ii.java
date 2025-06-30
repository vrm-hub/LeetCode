class Solution {
    List<List<Integer>> res;
    private void backtrack(int[] nums, int start, List<Integer> sub) {
        res.add(new ArrayList<>(sub));

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            sub.add(nums[i]);
            backtrack(nums, i + 1, sub);
            sub.remove(sub.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());

        return res;
    }
}

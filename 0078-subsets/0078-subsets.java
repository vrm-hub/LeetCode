class Solution {
    List<List<Integer>> res;
    private void backtrack(int[] nums, int start, List<Integer> subset) {
        res.add(new ArrayList<>(subset));

        for(int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i+1, subset);
            subset.remove(subset.size() - 1);
        }

        // subset.add(nums[start]);
        // backtrack(nums, start + 1, subset);
        // subset.remove(subset.size() - 1);
        // backtrack(nums, start + 1, subset);
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(nums, 0, subset);

        return res;
    }
}

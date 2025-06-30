class Solution {
    List<List<Integer>> res;
    private void backtrack(int[] nums, int target, int total, int index, List<Integer> sub) {
        if(total == target) {
            res.add(new ArrayList<>(sub));
        }

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if(total + nums[i] > target) {
                break;
            }
            sub.add(nums[i]);
            backtrack(nums, target, total + nums[i], i + 1, sub);
            sub.remove(sub.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums, target, 0, 0, new ArrayList<>());

        return res;
    }
}

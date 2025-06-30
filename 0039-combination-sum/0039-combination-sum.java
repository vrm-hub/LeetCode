class Solution {
    List<List<Integer>> res;
    private void backtrack(int[] nums, int target, int total, int start, List<Integer> curr) {
        if(total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(total + nums[i] > target) {
                break;
            }
            
            curr.add(nums[i]);
            backtrack(nums, target, total + nums[i], i, curr);
            curr.remove(curr.size() - 1);
        }


    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums, target, 0, 0, new ArrayList<>());

        return res;
    }
}

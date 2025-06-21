class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int res = nums[nums.length - 1];
        int count = 0;
        for(int i = nums.length - 2; i >= 0; i --) {
            if(nums[i] == nums[i + 1]){
                continue;
            }

            count++;
            if(count == 2) {
                res = nums[i];
                break;
            }
        }

        return res;
    }
}
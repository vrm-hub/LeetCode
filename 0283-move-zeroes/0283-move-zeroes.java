class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 1;

        while(l < nums.length) {
            r = l + 1;
            if(nums[l] == 0) {
                while(r < nums.length && nums[r] == 0) {
                    r++;
                }
                if(r < nums.length) {
                    int temp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = temp;
                }
            }
            l++;
        }
    }
}
class Solution {
    private void swap(int[] nums, int l, int r) {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }
    public void moveZeroes(int[] nums) {
        int l = 0;

        while(l < nums.length - 1) {
            int r = l + 1;
            if(nums[l] == 0) {
                while(r < nums.length - 1 && nums[r] == 0) {
                    r++;
                }
                swap(nums, l, r);
            }
            l++;
        }
    }
}
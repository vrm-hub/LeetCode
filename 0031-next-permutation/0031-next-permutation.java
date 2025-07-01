class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for(i = nums.length - 1; i > 0; i--) {
            if(nums[i-1] < nums[i]) break;
        }

        if(i == 0) {
            reverse(nums, i);
            return;
        }

        int j = nums.length - 1;
        while(j >= i && nums[j] <= nums[i-1]) {
            j--;
        }

        //swap the elements
        int temp = nums[i-1];
        nums[i-1] = nums[j];
        nums[j] = temp;

        //reverse the from the first decreasing element from the right (index i)
        reverse(nums, i);
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
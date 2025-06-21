class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxL = 0;
        int l = 0, r = 0;
        int f = k;

        while(l < nums.length) {
            while(r < nums.length && (nums[r] == 1 || k > 0)) {
                if(nums[r] == 0) {
                    k--;
                }
                r++;
            }
            maxL = Math.max(maxL, r - l);

            if(nums[l] == 0 && k < f) {
                k++;
            }
            l++;
            if(l > r) {
                r = l;
            }
        }

        return maxL;
    }
}
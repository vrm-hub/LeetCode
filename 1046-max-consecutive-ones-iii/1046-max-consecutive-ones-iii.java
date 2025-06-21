class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, zeros = 0, maxL = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) zeros++;

            if(zeros <= k)
                maxL = Math.max(maxL, r - l + 1);
            while (zeros > k) {
                if (nums[l] == 0) zeros--;
                l++;
            }
        }

        return maxL;
    }
}
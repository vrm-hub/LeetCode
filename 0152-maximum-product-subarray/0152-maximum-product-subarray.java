class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre = 1, suf = 1;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(pre == 0) {
                pre = 1;
            }
            if(suf == 0) {
                suf = 1;
            }

            pre = pre * nums[i];
            suf = suf * nums[n - i - 1];

            max = Math.max(max, Math.max(pre, suf));
        }

        return max;
    }
}

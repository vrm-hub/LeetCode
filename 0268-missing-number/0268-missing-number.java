class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length + 1; i++) {
            sum = sum + i;
        }
        for(int i : nums) {
            sum = sum - i;
        }

        return sum;
    }
}
class Solution {
    public int missingNumber(int[] nums) {
        int[] num = new int[nums.length + 1];
        for(int i : nums) {
            num[i] = 1;
        }

        for(int i = 0; i < num.length; i++) {
            if(num[i] == 0) return i;
        }

        return -1;
    }
}
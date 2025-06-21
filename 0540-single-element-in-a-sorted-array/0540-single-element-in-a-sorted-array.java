class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l+r)/2;
            if(mid % 2 == 1) {
                mid--;
            }

            if(mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                l = mid + 2;
                continue;
            } else if(mid > 0 && nums[mid] == nums[mid - 1]) {
                r = r - 2;
                continue;
            }

            return nums[mid];
        }

        return -1;
    }
}
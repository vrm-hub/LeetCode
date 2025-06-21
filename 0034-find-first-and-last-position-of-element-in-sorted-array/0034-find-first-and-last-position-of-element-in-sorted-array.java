class Solution {
    private int binarySearch(int l, int r, int[] nums, int target) {
        if(l > r) {
            return -1;
        }

        int mid = (l + r) / 2;
        if(nums[mid] > target) {
            return binarySearch(l, mid -1, nums, target);
        } else if(nums[mid] < target) {
            return binarySearch(mid + 1, r, nums, target);
        }

        return mid;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int pos = binarySearch(0, nums.length - 1, nums, target);
        if(pos == -1) {
            return res;
        }
        int lpos = pos;
        int rpos = pos;
        Boolean lflag = true, rflag = true;

        while(lflag) {
            int temp = lpos;
            lpos = binarySearch(0, lpos - 1, nums, target);
            if(lpos == -1) {
                lflag = false;
                lpos = temp;
            }
        }

        while(rflag) {
            int temp = rpos;
            rpos = binarySearch(rpos + 1, nums.length - 1, nums, target);
            if(rpos == -1) {
                rflag = false;
                rpos = temp;
            }
        }

        return new int[]{lpos, rpos};
    }
}
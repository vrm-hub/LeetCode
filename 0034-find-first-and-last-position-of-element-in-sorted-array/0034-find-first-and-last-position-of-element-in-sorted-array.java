class Solution {
    private int lbinarySearch(int l, int r, int[] nums, int target) {
        if(l > r) {
            return -1;
        }

        int mid = (l + r) / 2;
        if(nums[mid] > target) {
            return lbinarySearch(l, mid -1, nums, target);
        } else if(nums[mid] < target) {
            return lbinarySearch(mid + 1, r, nums, target);
        }

        if(mid > 0 && nums[mid - 1] == target) {
            return lbinarySearch(l, mid - 1, nums, target);
        }

        return mid;
    }

    private int rbinarySearch(int l, int r, int[] nums, int target) {
        if(l > r) {
            return -1;
        }

        int mid = (l + r) / 2;
        if(nums[mid] > target) {
            return rbinarySearch(l, mid -1, nums, target);
        } else if(nums[mid] < target) {
            return rbinarySearch(mid + 1, r, nums, target);
        }

        if(mid < nums.length - 1 && nums[mid + 1] == target) {
            return rbinarySearch(mid + 1, nums.length, nums, target);
        }

        return mid;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{lbinarySearch(0, nums.length - 1, nums, target), rbinarySearch(0, nums.length - 1, nums, target)};
    }
}
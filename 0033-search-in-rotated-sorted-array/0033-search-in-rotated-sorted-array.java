class Solution {
    private int binarySearch(int l, int r, int[] nums, int target) {
        if(l > r) {
            return -1;
        }
        
        int mid = (l + r) / 2;
        
        if(target > nums[mid]) {
            return binarySearch(mid + 1, r, nums, target);
        } else if (target < nums[mid]) {
            return binarySearch(l, mid - 1, nums, target);
        }
        
        return mid;
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, res = nums[0], index = 0;

        if(nums[l] <= nums[r]) {
            return binarySearch(l, r, nums, target);
        }

        while(l <= r) {
            if(nums[l] < nums[r]) {
                if(nums[l] < res) {
                    res = nums[l];
                    index = l;
                }
                break;
            }
            
            int mid = (l + r) / 2;

            if(nums[mid] < res) {
                res = nums[mid];
                index = mid;
            }
            if(nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(index);

        if(target >= nums[0]) {
            return binarySearch(0, index - 1, nums, target);
        }

        return binarySearch(index, nums.length - 1, nums, target);
    }
}
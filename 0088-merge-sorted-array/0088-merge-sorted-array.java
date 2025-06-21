class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1, r = n - 1;
        int index = nums1.length - 1;
        
        while(r >= 0) {
            if(l < 0) {
                nums1[index] = nums2[r];
                index--;
                r--;
                continue;
            }

            if(nums2[r] >= nums1[l]) {
                nums1[index] = nums2[r];
                r--;
            } else {
                nums1[index] = nums1[l];
                l--;
            }
            index--;
        }
    }
}
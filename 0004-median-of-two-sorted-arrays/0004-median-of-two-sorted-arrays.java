class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = nums1.length;
        int mid = (low + high)/2;
        while(low <= high) {
            int mid1 = (low + high)/2;
            int mid2 = (nums1.length + nums2.length + 1)/2 - mid1;
            int l1, l2, r1, r2;
            if(mid1 - 1 < 0) {
                l1 = Integer.MIN_VALUE;
            } else {
                l1 = nums1[mid1 - 1];
            }

            if(mid2 - 1 < 0) {
                l2 = Integer.MIN_VALUE;
            } else {
                l2 = nums2[mid2 - 1];
            }

            if(mid1 >= nums1.length) {
                r1 = Integer.MAX_VALUE;
            } else {
                r1 = nums1[mid1];
            }

            if(mid2 >= nums2.length) {
                r2 = Integer.MAX_VALUE;
            } else {
                r2 = nums2[mid2];
            }

            if(l1 > r2) high = mid1 - 1;
            else if(l2 > r1) low = mid1 + 1;
            else if(l1 <= r2 && l2 <= r1) {
                return (nums1.length + nums2.length) % 2 == 0 ? (double)(Math.max(l1, l2) + Math.min(r1, r2))/2 : (double)Math.max(l1,l2);
            }
        }

        return 0;
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int l = 0, r = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int m = (len1 + len2) / 2;
        int median1 = 0, median2 = 0;
    
        while(i < m + 1) {
            median2 = median1;
            if (l < len1 && r < len2) {
                if (nums1[l] > nums2[r]) {
                    median1 = nums2[r];
                    r++;
                } else {
                    median1 = nums1[l];
                    l++;
                }
            } else if (l < len1) {
                median1 = nums1[l];
                l++;
            } else {
                median1 = nums2[r];
                r++;
            }
            i++;
        }

        if((len1 + len2) % 2 == 0) return (double)(median1 + median2) / 2;

        return median1;
    }
}

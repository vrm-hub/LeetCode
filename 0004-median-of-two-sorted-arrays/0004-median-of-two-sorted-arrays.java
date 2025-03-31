class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianIndex1 = -2;
        int medianIndex2 = -2;
        int m1, m2;
        if((nums1.length + nums2.length) %2 == 0) {
            medianIndex1 = (nums1.length + nums2.length) / 2 - 1;
            medianIndex2 = (nums1.length + nums2.length) / 2;
        } else {
            medianIndex1 = (nums1.length + nums2.length) / 2;
        }
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0, j = 0, c = 0; 
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                arr[c] = nums1[i];
                i++;
            } else { 
                arr[c] = nums2[j];
                j++;
            }

            c++;
        }

        if(i >= nums1.length) {
            while(j < nums2.length) {
                arr[c] = nums2[j];
                j++;
                c++;
            }
        } else if(j >= nums2.length) {
            while(i < nums1.length) {
                arr[c] = nums1[i];
                i++;
                c++;
            }
        }


        
        if(medianIndex2 != -2) {
            return (double) (arr[medianIndex1] + arr[medianIndex2])/2;
        } else {
            return (double) arr[medianIndex1];
        }
    }
}
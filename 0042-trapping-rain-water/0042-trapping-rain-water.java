class Solution {
    public int trap(int[] height) {
        if(height.length == 0 || height == null) return 0;

        int n = height.length;
        int res = 0;
        int l = 0;
        int r = n-1;
        int leftMax = height[l];
        int rightMax = height[r];

        while(l < r) {
            if(leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;

    }
}

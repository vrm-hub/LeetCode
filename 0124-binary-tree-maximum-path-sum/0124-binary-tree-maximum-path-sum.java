/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxSum;
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        left = Math.max(left, 0);
        int right = helper(root.right);
        right = Math.max(right, 0);

        maxSum = Math.max(maxSum, root.val + left + right);

        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        helper(root);
        return maxSum;
    }
}

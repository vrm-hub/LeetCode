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
    private int helper(TreeNode root, boolean[] b) {
        if(root == null) return 0;
        if(!b[0]) {
            return 0;
        }

        int left = helper(root.left, b);
        int right = helper(root.right, b);

        if (Math.abs(left - right) > 1) {
            b[0] = false;
        }

        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        boolean[] b = new boolean[] {true};

        helper(root, b);
        return b[0];
    }
}
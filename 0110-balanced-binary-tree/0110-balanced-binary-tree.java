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
    private int dfs(TreeNode root, boolean[] res){
        if(root == null || !res[0]) return 0;

        int left = dfs(root.left, res);
        int right = dfs(root.right, res);

        if(Math.abs(left - right) > 1) res[0] = false;

        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[]{true};
        if(root == null) return res[0];

        dfs(root, res);
        return res[0];
    }
}
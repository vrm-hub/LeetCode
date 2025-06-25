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
    boolean[] res = new boolean[1];
    private int dfs(TreeNode root, int level){
        if(root == null || !res[0]) return 0;

        int left = dfs(root.left, level);
        int right = dfs(root.right, level);

        if(Math.abs(left - right) > 1) res[0] = false;

        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        res[0] = true;
        if(root == null) return res[0];

        dfs(root, 0);
        return res[0];
    }
}
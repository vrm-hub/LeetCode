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
    int t = -1;
    int count = 1;
    private void inorder(TreeNode root, int k) {
        if(root == null) return;
        inorder(root.left, k);
        if(k == count) {
            t = root.val;
        }
        count++;

        if(k != 0) inorder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;

        inorder(root, k);

        return t;
    }
}

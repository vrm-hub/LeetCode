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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int length = q.size();
            for(int i = 0; i < length; i++) {
                TreeNode n = q.poll();
                if(n.val == val) return n;
                if(n.val > val && n.left == null || n.val < val && n.right == null) return null;
                if(n.val > val && n.left != null) q.offer(n.left);
                if(n.val < val && n.right != null) q.offer(n.right);
            }
        }

        return null;
    }
}
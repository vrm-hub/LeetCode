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
    private void traversalHelper(TreeNode root, ArrayList<Integer> res) {
        if(root == null) return;

        traversalHelper(root.left, res);
        res.add(root.val);
        traversalHelper(root.right, res);
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res= new ArrayList<>();

        if(root == null) return res;

        traversalHelper(root, res);

        return res;
    }
}
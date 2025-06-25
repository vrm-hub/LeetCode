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
    HashMap<Integer, Integer> map;
    int postIndex;
    private TreeNode inorder(int[] postorder, int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;

        root.right = inorder(postorder, map.get(root.val) + 1, end);
        root.left = inorder(postorder, start, map.get(root.val) - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return inorder(postorder, 0, postorder.length - 1);
    }
}
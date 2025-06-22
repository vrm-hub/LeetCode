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
    int postIndex;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return arrayToTree(postorder, 0, postorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        if(left > right) return null;
        int value = postorder[postIndex--];
        TreeNode root = new TreeNode(value);

        root.right = arrayToTree(postorder, map.get(value) + 1, right);
        root.left = arrayToTree(postorder, left, map.get(value) - 1);

        return root;
    }
}
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // Find the rightmost node in left subtree (inorder predecessor)
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Create a thread
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // Thread exists → revert it and process
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) x = pred;
                    }

                    pred = root;

                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                // No left child, process current node
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) x = pred;
                }

                pred = root;
                root = root.right;
            }
        }

        // Swap the values of the two nodes
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }
}

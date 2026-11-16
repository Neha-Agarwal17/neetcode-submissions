
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        // 1. Base case: key not found
        if (root == null) {
            return null;
        }

        // 2. Search in the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // 3. Search in the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // 4. Found the node to delete
        else {

            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: No right child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            // Find the smallest node in the right subtree
            TreeNode successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            // Copy successor's value into the current node
            root.val = successor.val;

            // Delete the successor from the right subtree
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}

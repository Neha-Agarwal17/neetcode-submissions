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
    public int depth(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);

        return (left>right?left:right) + 1;
    }
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
}

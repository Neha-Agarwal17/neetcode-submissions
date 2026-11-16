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
    boolean isBalancedTree = true;
    public int checkHeight(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }

        int lh = checkHeight(node.left);
        int rh = checkHeight(node.right);

        boolean check_curr = Math.abs(lh-rh)<=1;

        isBalancedTree = isBalancedTree && check_curr;
        return 1 + Math.max(lh,rh);
    }

    public boolean isBalanced(TreeNode root) {
        checkHeight(root);
        return isBalancedTree;
    }
}

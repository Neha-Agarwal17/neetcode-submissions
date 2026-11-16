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
    /*
    BRUTE FORCE SOLUTION - Check all lefts and rights 
    TC - O(N) SC - O(H)

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
    */
    /*OPTIMIZED SOLUTION - USE A SPECIAL NUMBER TO DENOTE IMBALNCED
    LIKE - -1
    IF LEFT HEIGHT == -1 RETURN -1
    IF RIGHT HEIGHT == -1 RETURN -1
    DO NOT LEFTS/RIGHTS OF A NODE WHOSE EITHER LEFT SUBTREE OR  
    RIGHT SUBTREE RETURNED -1
    */
    public int checkNode(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        int lh = checkNode(node.left);
        if(lh == -1) return -1;

        int rh = checkNode(node.right);
        if(rh == -1) return -1;

        if(Math.abs(lh-rh)>1)
        {
            return -1;
        }
        return 1 + Math.max(lh,rh);
    }

    public boolean isBalanced(TreeNode root) {
        return checkNode(root) != -1;
    }
}

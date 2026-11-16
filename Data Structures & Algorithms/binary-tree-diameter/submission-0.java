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

 /*
    node -

     
    check node2.left - found node 3 
    check node1.left first - found node 2
    check root.left first - found node 1
 */

class Solution {
    int diameter = 0;
    public int calculateDiameter(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }

        int lh = calculateDiameter(node.left);
        int rh = calculateDiameter(node.right);
        int curr_diameter = lh+rh;
        diameter = Math.max(curr_diameter, diameter);

        return 1 + Math.max(lh,rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {

        calculateDiameter(root);
        return diameter;
    }
}

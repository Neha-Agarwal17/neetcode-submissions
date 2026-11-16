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
    boolean found = false;
    public boolean insert(TreeNode node, TreeNode newNode)
    {
        if(node == null)
        {
            return true;
        }
        if(node.val > newNode.val)
        {
            boolean inLeft = insert(node.left, newNode);
            if(found == false && inLeft == true)
            {
                node.left = newNode;
                found = true;
                return true;
            }
        }
        else
        {
            boolean inRight = insert(node.right, newNode);
            if(found == false && inRight == true)
            {
                node.right = newNode;
                found = true;
                return true;
            }
        }
        return false;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val, null, null);
        if(root == null)
        {
            root = newNode;
        }
        else
        {
            boolean inserted = insert(root,newNode);
        }
        return root;
    }
}
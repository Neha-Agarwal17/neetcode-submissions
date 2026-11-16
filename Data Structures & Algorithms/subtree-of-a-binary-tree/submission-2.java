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
    public int checkSame(TreeNode n1, TreeNode n2)
    {
        if(n1 == null && n2 == null)
        {
            return 0;
        }
        else if(n1 == null && n2!=null)
        {
            return -1;
        }
        else if(n1 != null && n2 == null)
        {
            return -1;
        }
        else if(n1.val !=n2.val)
        {
            return -1;
        }

        int checkLeft = checkSame(n1.left, n2.left);
        if(checkLeft == -1)
        {
            return -1;
        }
        int checkRight = checkSame(n1.right, n2.right);
        if(checkRight == -1)
        {
            return -1;
        }
        return 0;
    }
    public boolean findNode(TreeNode n1, TreeNode n2)
    {
        if(n2 == null)
        {
            //an empty node is considered a subtree of all tree
            return true;
        }
        if(n1 == null)
        {
            return false;
        }
        if (n1.val == n2.val && checkSame(n1, n2) == 0)
        {
            return true;
        }
        boolean findLeft = findNode(n1.left, n2);
        if(findLeft == true)
        {
            return true;
        }
        boolean findRight = findNode(n1.right, n2);
        if(findRight == true)
        {
            return true;
        }
        return findLeft || findRight;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return findNode(root, subRoot);
    }
}

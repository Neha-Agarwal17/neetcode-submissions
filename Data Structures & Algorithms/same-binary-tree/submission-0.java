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
    public int same(TreeNode n1, TreeNode n2)
    {
        if(n1==null && n2==null)
        {
            return 0;
        }
        else if(n1!=null && n2==null)
        {
            return -1;
        }
        else if(n1==null && n2!=null)
        {
            return -1;
        }
        else if(n1.val!=n2.val)
        {
            return -1;
        }

        int leftEquals = same(n1.left,n2.left);
        if(leftEquals == -1)
        {
            return -1;
        }
        int rightEquals = same(n1.right, n2.right);
        if(rightEquals == -1)
        {
            return -1;
        }
        return 0;
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        return same(p,q) == 0;
    }
}

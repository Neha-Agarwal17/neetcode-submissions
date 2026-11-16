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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root==null)
        {
            return list; 
        }
        que.offer(root);
        //After all nodes are polled and traversed, queue becomes empty 
        while(!que.isEmpty())
        {
            TreeNode rightNode = null;
            //Go level by level
            int level_size = que.size();
            for(int i=0;i<level_size;i++)
            {
                //take out first node in que - 1 -> 2 -> 3 -> 4
                TreeNode node = que.poll();
                // Always set the rightNode for each element at each level,
                // the node at the last of the level wise iteration becomes the rightmost element
                rightNode = node;
                
                // Always insert all nodes, left and right, but rightNode would only be the last iteration
                if(node.left!=null)
                {
                    que.offer(node.left);
                }
                if(node.right!=null)
                {
                    que.offer(node.right);
                }
            }
            //After each level wise iteration, add the right node in list for that level
            list.add(rightNode.val);
        }
        //returing list with all rightNodes
        return list;
    }
}

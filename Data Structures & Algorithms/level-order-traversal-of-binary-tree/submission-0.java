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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
        {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                if(queue.peek().left!=null){queue.offer(queue.peek().left);}
                if(queue.peek().right!=null){queue.offer(queue.peek().right);}
                list.add(queue.poll().val);
            }
            res.add(list);
        }
        return res;
    }
}

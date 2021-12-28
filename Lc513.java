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
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            result = que.peek().val;
            while(len > 0){
                TreeNode temp =  que.poll();
                if(temp.left != null) que.offer(temp.left);
                if(temp.right != null) que.offer(temp.right);
                len--;
            }
        }
        return result;
    }
}

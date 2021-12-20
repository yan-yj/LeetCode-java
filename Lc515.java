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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            int large = que.peek().val;
            while(len > 0){
                TreeNode temp = que.poll();
                if(temp.val > large) large = temp.val;
                if(temp.left != null) que.offer(temp.left);
                if(temp.right != null) que.offer(temp.right);
                len--;
            }
            result.add(large);
        }
        return result;
    }
}

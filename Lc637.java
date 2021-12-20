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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;
        // 使用辅助队列进行层次遍历
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            int num = len;
            Double sum = 0.0;
            while(len > 0){
                TreeNode temp = que.poll();
                sum += temp.val;
                if(temp.left != null) que.offer(temp.left);
                if(temp.right != null) que.offer(temp.right);
                len--;
            }
            result.add(sum/num);
        }
        return result;
    }
}

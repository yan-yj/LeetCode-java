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
    public int countNodes(TreeNode root) {

        // 递归解法
        // if(root == null) return 0;
        // int num = 0;
        // int leftNum = countNodes(root.left);
        // int rightNum = countNodes(root.right);
        // num = leftNum + rightNum + 1;
        // return num;

        // 迭代解法
        if(root == null) return 0;
        int result = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            result += len;
            while(len > 0){
                TreeNode temp = que.poll();
                if(temp.left != null) que.offer(temp.left);
                if(temp.right != null) que.offer(temp.right);
                len--;
            }
        }
        return result;
    }
}

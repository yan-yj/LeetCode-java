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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            while(len > 0){
                TreeNode temp = que.poll();
                if(temp.left != null) que.offer(temp.left);
                if(temp.right != null) que.offer(temp.right);
                if(isSameTree(temp, subRoot)) return true;
                len--;
            }
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q){

        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        if(p.val != q.val) return false;

        boolean node_left = isSameTree(p.left, q.left);
        boolean node_right = isSameTree(p.right, q.right);

        return node_left && node_right;
    }
}

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
    List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // checkFun1(root, 0);
        checkFun2(root);
        Collections.reverse(resList);
        return resList;
    }

    // 递归解法
    public void checkFun1(TreeNode root, int deep){
        if(root == null) return;
        deep++;
        if(resList.size() < deep){
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(deep - 1).add(root.val);
        checkFun1(root.left, deep);
        checkFun1(root.right, deep);
    }

    // 迭代解法，使用辅助队列
    public void checkFun2(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> item = new ArrayList<>();
            int len = que.size();
            while(len > 0){
                TreeNode temp = que.poll();
                item.add(temp.val);
                if(temp.left != null) que.offer(temp.left);
                if(temp.right != null) que.offer(temp.right);
                len--;
            }
            resList.add(item);
        }   
    }
}

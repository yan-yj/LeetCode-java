/**
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
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
    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode preNode;
    public int[] findMode(TreeNode root) {
        // 只有一个元素
        if(root.left == null && root.right == null){
            int[] res = {root.val};
            return res;
        }
            
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        preNode = null;
        do_task(root);
        int[] res = new int[resList.size()];
        for(int i = 0; i < resList.size(); i++){
            res[i] = resList.get(i);
        }
        return res;
    }

    public void do_task(TreeNode root){
        if(root == null) return;

        do_task(root.left);

        // 开始计数
        if(preNode == null || preNode.val != root.val) {
            count = 1;
        }else{
            count++;
        }
        // 更新maxCount
        if(count > maxCount){
            maxCount = count;
            resList.clear();
            resList.add(root.val);
        }else if(count == maxCount){
            resList.add(root.val);
        }
        preNode = root;

        do_task(root.right);
    }
}

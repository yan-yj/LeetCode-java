/**

You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // return method_rec(root, val);
        return method_vis(root, val);
    }

    // 递归法
    public TreeNode method_rec(TreeNode root, int val){
        if(root == null) return new TreeNode(val);

        if(root.val > val) root.left = method_rec(root.left, val);
        if(root.val < val) root.right = method_rec(root.right, val);

        return root;
    }

    // 迭代法
    public TreeNode method_vis(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        TreeNode preNode = root;
        TreeNode newNode = root;

        while(root != null){
            preNode = root;
            if(root.val > val) {
                root = root.left;
            }else{
                root = root.right;
            }
        }

        if(preNode.val > val){
            preNode.left = new TreeNode(val);
        }else{
            preNode.right = new TreeNode(val);
        }

        return newNode;
    }
}

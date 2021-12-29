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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        int sum = root.val;
        return hasPath(root, sum, targetSum);
    }

    public boolean hasPath(TreeNode root, int sum, int target){
        if(root.left == null && root.right == null){
            if(sum == target) return true;
            else return false;
        }

        boolean left = false, right = false;
        if(root.left != null){
            left = hasPath(root.left, sum + root.left.val, target);
        }
        if(root.right != null){
            right = hasPath(root.right, sum + root.right.val, target);
        }

        return left||right;
    }
}

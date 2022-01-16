/**
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length);
    }

    // 有序数组中间的元素作为root，递归创建平衡二叉树
    public TreeNode createTree(int[] nums, int leftIndex, int rightIndex) {
        if(leftIndex >= rightIndex ) {
            return null;
        } 
        int mid = (leftIndex + rightIndex)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, leftIndex, mid);
        root.right = createTree(nums, mid + 1, rightIndex);
        return root;
    }
}

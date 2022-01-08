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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // if(nums == null) return null;
        return createTree(nums, 0, nums.length);
    }

    public TreeNode createTree(int[] nums, int left, int right){
        // 没有元素，终止递归
        if(right - left < 1) return null;

        // 只剩一个元素，终止递归
        if(right - left == 1) return new TreeNode(nums[left]);

        int maxIndex = left;
        int maxVal = nums[left];

        for(int i = left + 1; i < right; i++){
            if(nums[i] > maxVal){
                maxIndex = i;
                maxVal = nums[maxIndex];
            }
        }

        TreeNode root = new TreeNode(maxVal);

        // 根据maxIndex划分左右子树,进行递归
        root.left = createTree(nums, left, maxIndex);
        root.right = createTree(nums, maxIndex + 1, right);

        return root;
    }
}

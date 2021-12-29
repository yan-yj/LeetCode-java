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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> path = new LinkedList<>();
        preorderdfs(root, result, path, targetSum);
        return result;
    }

    public void preorderdfs(TreeNode root, List<List<Integer>> result, List<Integer> path, int target){
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(target - root.val == 0)
                result.add(new ArrayList<>(path));
            return;
        }

        if(root.left != null){
            preorderdfs(root.left, result, path, target - root.val);
            path.remove(path.size() - 1);
        }

        if(root.right != null){
            preorderdfs(root.right, result, path, target - root.val);
            path.remove(path.size() - 1);
        }
    }
}

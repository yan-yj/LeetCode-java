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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;

        List<Integer> path = new ArrayList<>();
        travel(root, res, path);
        return res;
    }

    public void travel(TreeNode root, List<String> res, List<Integer> path){
        path.add(root.val);
        if(root.right == null && root.left == null){
            StringBuilder sb = new StringBuilder();
            sb.append(path.get(0));
            for(int i = 1; i < path.size(); i++){
                sb.append("->").append(path.get(i));
            }
            res.add(sb.toString());
            return;
        }
        if(root.left != null){
            travel(root.left, res, path);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            travel(root.right, res, path);
            path.remove(path.size()-1);
        }
    }
}

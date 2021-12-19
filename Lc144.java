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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        proOrder(root, result);
        return result;
    }

    void proOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        proOrder(root.left, result);
        proOrder(root.right, result);
    }

//     迭代解法
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if(root == null){
//             return result;
//         }
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
//         while(!stack.isEmpty()){
//             TreeNode node = stack.pop();
//             result.add(node.val);
//             if(node.right != null){
//                 stack.push(node.right);
//             }
//             if(node.left != null){
//                 stack.push(node.left);
//             }
//         }
//         return result;
//     }
}

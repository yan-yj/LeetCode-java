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
    public List<Integer> postorderTraversal(TreeNode root) {
        // 存放结果
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    void postOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
    
    
//     迭代解法，按中->右->左的顺序遍历，最后反转结果    
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if(root == null){
//             return result;
//         }
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
//         while(!stack.isEmpty()){
//             TreeNode node = stack.pop();
//             result.add(node.val);
//             if(node.left != null){
//                 stack.push(node.left);
//             }
//             if(node.right != null){
//                 stack.push(node.right);
//             }
//         }
//         Collections.reverse(result);
//         return result;
//     }
}

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    void inOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }

//     迭代解法，设置一个指针cur记录中序遍历过程
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if(root == null){
//             return result;
//         }
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode cur = root;
//         while(cur != null || !stack.isEmpty()){
//             if(cur != null){
//                 stack.push(cur);
//                 cur = cur.left;
//             }else{
//                 cur = stack.pop();
//                 result.add(cur.val);
//                 cur = cur.right;
//             }
//         }
//         return result;
//     }
}

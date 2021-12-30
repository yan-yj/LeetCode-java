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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode createTree(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight ){
        // array is empty
        if(inRight - inLeft < 1){
            return null;
        }
        // only one element
        if(inRight - inLeft == 1){
            return new TreeNode(inorder[inLeft]);
        }

        // get the root node
        int rootValue = postorder[postRight -1];
        TreeNode root = new TreeNode(rootValue);

        // find the point to divide inorder
        int rootIndex = 0;
        for(int i = inLeft; i < inRight; i++){
            if(rootValue == inorder[i]){
                rootIndex = i;
                break;
            }
        }

        // divide postorder
        root.left = createTree(inorder, inLeft, rootIndex, postorder, postLeft, postLeft+(rootIndex-inLeft));
        root.right = createTree(inorder, rootIndex+1, inRight, postorder, postLeft+(rootIndex-inLeft), postRight-1);

        return root;
    }
}

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode createTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight)
    {
        if(inLeft > inRight) return null;

        
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = preLeft;
        for(int i = inLeft; i <= inRight; i++){
            if(rootVal == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        
        root.left = createTree(preorder, preLeft + 1, preLeft + (rootIndex - inLeft), inorder, inLeft, rootIndex-1);
        root.right  = createTree(preorder, preLeft + (rootIndex - inLeft) + 1, preRight, inorder, rootIndex+1, inRight);

        return root;
    }
}

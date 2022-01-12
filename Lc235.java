/**
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 调整p、q顺序
        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        // 根据二叉搜索树的特点，大于p，小于q的即为公共节点
        while(root != null){
            if(root.val < p.val){
                root = root.right;
            }else if(root.val > q.val){
                root = root.left;
            }else break;
        }

        return root;
    }
}

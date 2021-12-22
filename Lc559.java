/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        // 递归解法，先序遍历
        // if(root == null) return 0;
        // int depth = 0;
        // for(Node node : root.children){
        //     depth = Math.max(depth, maxDepth(node));
        // }
        // return depth + 1;

        // 迭代解法
        int depth = 0;
        if(root == null) return depth;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            depth++;
            while(len > 0){
                Node temp = que.poll();
                for(Node node : temp.children){
                    que.offer(node);
                }
                len--;
            } 
        }
        return depth;
    }
}

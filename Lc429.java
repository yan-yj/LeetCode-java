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
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if(root == null) return resList;

        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int len = que.size();
            List<Integer> item = new ArrayList<>();
            while(len > 0){
                Node temp = que.poll();
                item.add(temp.val);
                // 注意对子节点的添加
                if(temp.children != null){
                    for(Node node : temp.children){
                        que.offer(node);
                    }
                }
                len--;
            }
            resList.add(item);
        }
        return resList;
    }
}

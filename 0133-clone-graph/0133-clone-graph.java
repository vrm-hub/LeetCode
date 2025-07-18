/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private void dfs(Node node, Map<Node, Node> map) {
        if(map.containsKey(node)) return;

        Node n = new Node(node.val);
        map.put(node, n);
        
        for(Node nei : node.neighbors) {
            if(!map.containsKey(nei)) dfs(nei, map);
            n.neighbors.add(map.get(nei));
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        dfs(node, map);

        return map.get(node);
    }
}
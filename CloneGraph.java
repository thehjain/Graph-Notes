
//They will give you node
//and you have to copy the graph
//using that node

//Here structure of Node is
// class Node{
//     int val;
//     List<Node> neighbor;
//     Node(){
//         neighbor=new ArrayList<>();
//     }
// }

public Node cloneGraph(Node node) {
    if (node == null) return null;

    Node copy = new Node(node.val);

    Queue<Node> que = new LinkedList<>();
    Map<Node, Node> map = new HashMap<>();

    que.add(node);
    map.put(node, copy);

    while (!que.isEmpty()) {
        Node curr = que.poll();
        for (Node ele : curr.neighbors) {
            if (!map.containsKey(ele)) {
                map.put(ele, new Node(ele.val));
                que.add(ele);
            }
            map.get(curr).neighbors.add(map.get(ele));
        }
    }
    return copy;
}
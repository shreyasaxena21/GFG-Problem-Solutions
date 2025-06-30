/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    static class Pair{
        Node node;
        int hd;
        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        // code here
        if(root == null) return result;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            Node currentNode = pair.node;
            int horDistance = pair.hd;
            
                map.put(horDistance, currentNode.data);
            
            if(currentNode.left != null){
                queue.add(new Pair(currentNode.left, horDistance - 1));
            }
            if(currentNode.right != null){
                queue.add(new Pair(currentNode.right, horDistance + 1));
            }
        }
        for(int v : map.values()){
            result.add(v);
        }
        return result;
    }
}
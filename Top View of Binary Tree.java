/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
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
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            Node currentNode = pair.node;
            int horDistance = pair.hd;
            if(map.get(horDistance)==null){
                map.put(horDistance, currentNode.data);
                
            }
            
            if(currentNode.left!=null){
                queue.add(new Pair(currentNode.left, horDistance-1));
            }
            
            if(currentNode.right!=null){
                queue.add(new Pair(currentNode.right, horDistance+1));
            }
            
            
        }
        
        for(int v : map.values()){
            result.add(v);
        }
        
        return result;
        
    }
}
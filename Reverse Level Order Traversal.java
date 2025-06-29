/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            stack.push(currentNode.data);
            
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
            
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            
        }
        
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        
        return result;
    }
}
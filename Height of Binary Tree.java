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

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        
        //base case
        if(node==null){
            return -1;
        }
        
        //Approach1-DFT
        int left = height(node.left);
        int right = height(node.right);
        int max = Math.max(left, right);
        return max+1;
    }
}
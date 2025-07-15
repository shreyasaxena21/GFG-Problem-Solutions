/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution {
    
    public static Node reverseList(Node head){
        Node current = head;
        Node prev = null;
        
        while(current!=null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    public static void rearrange(Node odd) {
        // add your code here
        if(odd==null || odd.next==null){
            return;
        }
        
        // step 1- extract even LL
        Node even = odd.next;
        Node oddCurrent = odd;
        Node evenCurrent = even;
        
        //looping
        while(evenCurrent!=null && evenCurrent.next!=null){
            oddCurrent.next = evenCurrent.next;
            oddCurrent = oddCurrent.next;
            evenCurrent.next = oddCurrent.next;
            evenCurrent = evenCurrent.next;
        }
        
        oddCurrent.next = null;
        even = reverseList(even);
        oddCurrent.next = even;
    }
}
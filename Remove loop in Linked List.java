class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop using Floyd's cycle detection
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected
            if (slow == fast) {
                break;
            }
        }

        // If loop exists
        if (slow == fast) {
            slow = head;

            // Special case: If loop starts from head node
            if (slow == fast) {
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
                return;
            }

            // Step 2: Find the start of the loop
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            // Step 3: Break the loop
            fast.next = null;
        }
    }
}

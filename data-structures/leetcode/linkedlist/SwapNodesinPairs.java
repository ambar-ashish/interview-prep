package linkedlist;

//LC-24
public class SwapNodesinPairs {

    //Recursive approach
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    public ListNode swap(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode second = head.next;
        head.next = swap(head.next.next);
        second.next = head;
        return second;
    }

    //Iterative method
    public ListNode swapPairsIterative(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}

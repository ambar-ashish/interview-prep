package linkedlist;

//LC-206
public class ReverseLinkedList {

    //Using recursion
    //Time Complexity - O(N) where N is the size of the linked list
    //Space Complexity - O(N) since N is the size of the recursion stack
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode reversedHead =  reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }

    //Using Iterative method
    //Time Complexity - O(N) where N is the size of the linked list
    //Space Complexity - O(1)
    public ListNode reverseListIteratively(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

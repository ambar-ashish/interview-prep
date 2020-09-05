package linkedlist;

//LC-83
public class RemoveDuplicatesfromSortedList {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

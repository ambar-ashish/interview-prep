package linkedlist;

//LC-142
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode temp = head;
                while(slow != temp){
                    slow = slow.next;
                    temp = temp.next;
                }
                return slow;
            }
        }
        return null;
    }
}

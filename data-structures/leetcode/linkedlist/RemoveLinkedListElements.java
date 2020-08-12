package linkedlist;

//LC-203
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
            if(curr.val == val){
                ListNode temp = curr.next;
                prev.next = temp;
                curr = temp;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}

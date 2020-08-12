package linkedlist;

//LC-61
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        ListNode temp = head;
        int length = 0;
        ListNode last = null;
        while(temp != null){
            last = temp;
            temp = temp.next;
            length++;
        }
        last.next = head;

        ListNode newTail = head;
        for(int i=0 ; i< length - k % length - 1; i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}

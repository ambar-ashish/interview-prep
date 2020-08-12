package linkedlist;

//LC-445
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = add(reverseList(l1), reverseList(l2));
        return reverseList(temp);
    }

    public ListNode reverseList(ListNode head) {
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

    public ListNode add(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while(l1 != null && l2 != null){
            int value = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            head.next = new ListNode(value);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null){
            while(l2 != null){
                int value = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                head.next = new ListNode(value);
                head = head.next;
                l2 = l2.next;
            }
        }

        if(l2 == null){
            while(l1 != null){
                int value = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                head.next = new ListNode(value);
                head = head.next;
                l1 = l1.next;
            }
        }
        if(carry == 1){
            head.next = new ListNode(carry);
        }
        return dummy.next;
    }
}

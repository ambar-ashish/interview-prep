package linkedlist;

//LC-2
public class AddTwoNumbers {

    //Time complexity : O(max(m, n))
    //Space complexity : O(max(m, n)) (+1 for carry)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

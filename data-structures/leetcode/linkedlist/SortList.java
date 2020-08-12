package linkedlist;

//LC-148
public class SortList {

    //Using Merge Sort Divide and Conquer Approach
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeTwoLists(left, right);
    }

    //Time Complexity: O(n + m) Worst case where n and m are large lists
    //Space Complexity: O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                head.next = l2;
                l2 = l2.next;
            }else{
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        if(l1 == null && l2 != null){
            head.next = l2;
        }
        if(l2 == null && l1 != null){
            head.next = l1;
        }
        return dummy.next;
    }
}

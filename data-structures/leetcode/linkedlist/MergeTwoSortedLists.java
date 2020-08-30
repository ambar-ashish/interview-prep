package linkedlist;

//LC-21
public class MergeTwoSortedLists {

    //Time Complexity - O(n+m)
    //Space Complexity - O(1)
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode dummy =  new ListNode(0);
        ListNode head = dummy;
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                head.next = n1;
                n1 = n1.next;
                head = head.next;
            }else{
                head.next = n2;
                head = head.next;
                n2 = n2.next;
            }
        }
        if( n1 != null){
            head.next = n1;
        }else{
            head.next = n2;
        }
        return dummy.next;
    }
}

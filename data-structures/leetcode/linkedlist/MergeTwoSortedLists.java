package linkedlist;

//LC-21
public class MergeTwoSortedLists {

    //Time Complexity - O(n+m)
    //Space Complexity - O(1)
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode head =  new ListNode(0);
        ListNode n = head;
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                n.next = n1;
                n1 = n1.next;
                n = n.next;
            }else{
                n.next = n2;
                n = n.next;
                n2 = n2.next;
            }
        }
        if( n1 != null){
            n.next = n1;
        }else{
            n.next = n2;
        }
        return head.next;
    }
}

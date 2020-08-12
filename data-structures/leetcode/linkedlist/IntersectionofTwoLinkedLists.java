package linkedlist;

import java.util.HashSet;

//LC-160
public class IntersectionofTwoLinkedLists {

    //Time Complexity : O(m+n)
    //Space Complexity : O(m) or O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        HashSet<ListNode> set = new HashSet();
        while(tempA != null){
            set.add(tempA);
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while(tempB != null){
            if(set.contains(tempB)){
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }
}

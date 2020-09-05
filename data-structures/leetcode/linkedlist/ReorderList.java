package linkedlist;

import java.util.LinkedList;

//LC-143
public class ReorderList {

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public void reorderListSubOptimalSolution(ListNode head) {
        if(head == null){
            return;
        }
        LinkedList<Integer> list = new LinkedList();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        ListNode temp1 = head;
        boolean isEven = false;
        while(temp1 != null){
            if(isEven){
                temp1.val = list.removeLast();
            }else{
                temp1.val = list.removeFirst();
            }
            isEven = !isEven;
            temp1 = temp1.next;
        }
    }
}

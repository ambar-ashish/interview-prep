package linkedlist;

import java.util.Stack;

//LC-234
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode curr = head;
        Stack<Integer> s = new Stack();
        while(curr != null){
            s.push(curr.val);
            curr = curr.next;
        }
        ListNode curr1 = head;
        while(!s.isEmpty()){
            if(curr1.val != s.pop()){
                return false;
            }
            curr1 = curr1.next;
        }
        return true;
    }
}

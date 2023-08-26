package LinkedListII;

import java.util.List;

import static LinkedListII.ListNode.insertNode;

public class PalindromeLinkedList {

    static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;
        while(slow!=null) {
            if(dummy.val!=slow.val) return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }
    static ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while(head!=null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode head = null;
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,2);
        head=insertNode(head,1);
        if(isPalindrome(head)==true)
            System.out.println("True");
        else
            System.out.println("False");
    }
}

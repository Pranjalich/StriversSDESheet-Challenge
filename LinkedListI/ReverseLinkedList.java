package LinkedListI;

import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head!=null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
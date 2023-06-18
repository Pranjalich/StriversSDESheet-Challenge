package LinkedListI;

public class MiddleLinkedList {
    public static void main(String[] args) {

    }
    private static ListNode middle(ListNode curr) {
        ListNode slow = curr, fast = curr;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

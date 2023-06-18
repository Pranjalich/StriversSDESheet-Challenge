package LinkedListI;

public class RemoveNthNodeFromBack {
    public static void main(String[] args) {

    }
    private static ListNode removeNth(ListNode node, int n) {
        ListNode fast = node;
        ListNode slow = node;
        ListNode head = new ListNode();
        head.next = node;
        for(int i=0;i<=n;i++) {
            fast = fast.next;
        }
        while(fast!=null) {
            fast=fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head.next;
    }
}

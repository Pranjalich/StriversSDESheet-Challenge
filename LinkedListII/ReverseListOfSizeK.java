package LinkedListII;

import java.util.HashSet;

import static LinkedListII.ListNode.insertNode;
import static LinkedListII.ListNode.printLinkedList;

public class ReverseListOfSizeK {
    static int lengthOfLinkedList(ListNode head) {
        int length = 0;
        while(head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
    //utility function to reverse k nodes in the list
    static ListNode reverseKNodes(ListNode head,int k) {
        if(head==null || head.next==null) return head;
        int length = lengthOfLinkedList(head);
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode curr, next;
        while(length>=k) {
            curr = pre.next;
            next = curr.next;
            for(int i=1;i<=k;i++) {
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = curr.next;
            }
            pre = curr;
            length-=k;
        }
        return dummyNode.next;
    }
    public static void main(String args[]) {
        ListNode head = null;
        int k = 3;
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,4);
        head=insertNode(head,5);
        head=insertNode(head,6);
        head=insertNode(head,7);
        head=insertNode(head,8);

        System.out.print("Original Linked List: ");
        printLinkedList(head);
        System.out.print("After Reversal of k nodes: ");
        ListNode newHead = reverseKNodes(head,k);
        printLinkedList(newHead);

    }
}

package LinkedListAndArrays;

import static LinkedListAndArrays.ListNode.insertNode;
import static LinkedListAndArrays.ListNode.printLinkedList;

public class RotateLinkedList {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null ||k==0) return head;
        ListNode temp = head;
        int len = 1;
        while(temp.next!=null) {
            temp = temp.next;
            len++;
        }
        k = k%len;
        k = len-k;
        temp.next = head;
        while(k>0) {
            temp = temp.next;
            k--;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = null;
        //inserting Node
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,4);
        head=insertNode(head,5);

        System.out.println("Original list: ");
        printLinkedList(head);

        int k = 2;
        ListNode newHead = rotateRight(head,k);

        System.out.println("After "+k+" iterations: ");
        printLinkedList(newHead);//list after rotating nodes
    }
}

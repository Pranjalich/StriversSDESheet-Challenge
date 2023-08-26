package LinkedListII;

import static LinkedListII.ListNode.*;

public class FlattenLinkedList {
    public static void main(String args[]) {
        ListNode head = null;
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
        System.out.print("After flatten nodes: ");
        ListNode newHead = flatten(head);
        printBottomLinkedList(newHead);
    }

    private static ListNode flatten(ListNode root) {
        if(root==null || root.next==null) {
            return root;
        }
        root.next = flatten(root.next);
        root = mergeTwoLists(root,root.next);
        return root;
    }

    private static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (a!=null && b!=null) {
            if(a.val<b.val) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        if(a!=null) {
            temp.bottom = a;
        } else {
            temp.bottom = b;
        }
        return res.bottom;
    }
}

package LinkedListAndArrays;

public class ListNode {
    int val;
    ListNode next;
    ListNode bottom;
    public ListNode(int val) {
        this.val=val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static ListNode insertNode(ListNode head,int val) {
        ListNode newNode = new ListNode(val);
        if(head == null) {
            head = newNode;
            return head;
        }

        ListNode temp = head;
        while(temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }
    public static void printLinkedList(ListNode head) {
        while(head.next != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println(head.val);
    }
    public static void printBottomLinkedList(ListNode head) {
        while(head.bottom != null) {
            System.out.print(head.val+"->");
            head = head.bottom;
        }
        System.out.println(head.val);
    }
}

package LinkedListII;

import static LinkedListII.ListNode.insertNode;

public class StartingPointOfLoop {
    static void createCycle(ListNode head,int pos) {
        ListNode ptr = head;
        ListNode temp = head;
        int cnt = 0;
        while(temp.next != null) {
            if(cnt != pos) {
                ++cnt;
                ptr = ptr.next;
            }
            temp = temp.next;
        }
        temp.next = ptr;
    }
    static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) {
                break;
            }
        }
        if(fast==null || fast.next==null) {
            return null;
        }
        fast = head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    public static void main(String args[]) {
        ListNode head = null;

        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,4);
        head=insertNode(head,3);
        head=insertNode(head,6);
        head=insertNode(head,10);

        createCycle(head,2);

        ListNode nodeRecieve = detectCycle(head);
        if(nodeRecieve == null) System.out.println("No cycle");
        else {
            ListNode temp = head;
            int pos = 0;
            while(temp!=nodeRecieve) {
                ++pos;
                temp = temp.next;
            }
            System.out.println("Tail connects at pos "+pos);
        }

    }
}

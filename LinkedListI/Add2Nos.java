package LinkedListI;

public class Add2Nos {
    public static void main(String[] args) {

    }
    private static ListNode addNumbers(ListNode node1, ListNode node2) {
        int carry = 0;
        ListNode head = new ListNode();
        ListNode curr = head;
        while (node1!=null || node2!=null || carry==1) {
            int sum = 0;
            if(node1!=null) {
                sum+= node1.val;
                node1 = node1.next;
            }
            if(node2!=null) {
                sum+= node2.val;
                node2 = node2.next;
            }
            sum+=carry;
            carry=sum/10;
            ListNode node = new ListNode(sum%10);
            curr.next=node;
            curr = curr.next;
        }
        return head.next;
    }
}

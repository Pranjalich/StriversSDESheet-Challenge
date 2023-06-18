package LinkedListI;

public class MergeTwoSorted {
    public static void main(String[] args) {

    }
    private static ListNode mergeSorted(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(-1);
        ListNode mergedNode = head;
        while(node1!= null && node2!=null) {
            if(node1.val<=node2.val) {
                mergedNode.next = node1;
                node1 = node1.next;
            } else {
                mergedNode.next = node2;
                node2 = node2.next;
            }
            mergedNode = mergedNode.next;
        }
        while(node1!=null){
            mergedNode.next = node1;
            node1 = node1.next;
            mergedNode = mergedNode.next;
        }
        while(node2!=null){
            mergedNode.next = node2;
            node2 = node2.next;
            mergedNode = mergedNode.next;
        }
        return head.next;
    }
}

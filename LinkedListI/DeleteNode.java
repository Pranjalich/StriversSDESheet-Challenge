package LinkedListI;

public class DeleteNode {
    public static void main(String[] args) {

    }
    public static void deleteNode(ListNode node) {
        //Step 1 : get the next node
        ListNode nextNode = node.next;
        //Step 2: copy next node val to curr node val
        node.val = nextNode.val;
        //Step 3: point curr node next to next node next
        node.next = nextNode.next;
        nextNode.next = null;
    }
}

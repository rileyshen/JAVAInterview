package src.com.exe.LinkedList;

/**
 * @Description:
 * @Author RileyShen
 * @Create 2021-07-13
 */


class LinkedList {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode middleNode = middleNode(node1);
        System.out.println(middleNode.val);


    }


    public static ListNode middleNode(ListNode head) {
        if (head != null || head.next != null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast.next.next != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next == null) {
            return slow;
        }
        return slow.next;
    }
}


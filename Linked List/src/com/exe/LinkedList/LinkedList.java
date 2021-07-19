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
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode middleNode = middleNode(node1);
        System.out.println(middleNode.val);


        ListNode newNode = list.reverseN(node1, 3);
        System.out.println(newNode);

        System.out.println(list.toString());
        ListNode news = list. reverseBetween(node1, 3, 5);
        System.out.println(news.toString());
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



    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}


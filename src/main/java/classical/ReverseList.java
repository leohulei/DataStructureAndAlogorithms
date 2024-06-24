package src.main.java.classical;

/**
 * 反转一个单链表
 * 输入: 1->2->3->4->5
 * 输出: 5->4->3->2->1
 */
public class ReverseList {
    static class ListNode{
        int val ;
        ListNode next ;

        public ListNode(int val, ListNode next) {
            this.val = val ;
            this.next = next;
        }
    }

    public static ListNode itterate(ListNode head) {
        ListNode prev = null;
        ListNode next;

        ListNode curr = head;//当前节点
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode prev = itterate(node1);
        while (prev != null){
            System.out.println(prev.val);
            prev = prev.next;
        }
//        System.out.println(prev);

    }
}

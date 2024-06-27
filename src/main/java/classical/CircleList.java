package src.main.java.classical;
/**
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达该节点，则链表中存在环
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */

import java.util.HashSet;
import java.util.Set;

public class CircleList {
    static class ListNode{
        int val ;
        ListNode next ;

        public ListNode(int val, ListNode next) {
            this.val = val ;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node5.next = node1;

        System.out.println(hasCicle(node1));
        System.out.println(towPoint(node1));
    }

    //我们使用set集合来判断节点是否重复出现
    public static boolean hasCicle(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            //遍历向集合添加node ，如果加不进去，说明出现过
            if (!set.add(head)) {
                return true;
            }
            head = head.next;

        }
        return false;
    }
    //使用双指针来解题
    //定义一个快指针quick 一个慢指针slow 如果没有环，那么quick指向null 如果有环，quick会与slow相遇

    public static boolean towPoint(ListNode head){
        if (head ==null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick){
            if (quick == null || quick.next == null) {
                return false;
            }
            //指针移位
            slow = slow.next;
            quick = quick.next;
        }

        return true;
    }
}

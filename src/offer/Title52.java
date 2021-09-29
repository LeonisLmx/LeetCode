package offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author: Urey
 * @Date: 2021/7/21
 */
public class Title52 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode a = headA,b = headB;
        while (a != null){
            set.add(a);
            a = a.next;
        }
        while (b != null){
            if (set.contains(b)){
                return b;
            }
            b = b.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Title52 title52 = new Title52();
        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        ListNode b = new ListNode(5);
        b.next = new ListNode(0);
        b.next.next = new ListNode(1);
        b.next.next = new ListNode(8);
        b.next.next.next = new ListNode(4);
        b.next.next.next.next = new ListNode(5);
        System.out.println(title52.getIntersectionNode(a,b));
    }
}

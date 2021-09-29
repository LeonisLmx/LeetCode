package offer;

import java.util.Stack;

/**
 * @Author: Urey
 * @Date: 2021/1/15
 */
public class Offer18 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        if (head.val == val){
            return head.next;
        }
        while (head.next != null){
            if (head.next.val != val){
                head = head.next;
            }else{
                head.next = head.next.next;
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Offer18 offer18 = new Offer18();
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        ListNode node = offer18.deleteNode(listNode,5);
        while (node.next != null){
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }
}

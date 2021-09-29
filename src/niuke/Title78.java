package niuke;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: Urey
 * @Date: 2021/8/20
 */
public class Title78 {

    public class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head){
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        ListNode node = new ListNode(0);
        ListNode result = node;
        while (stack.size() > 0){
            result.next = new ListNode(stack.pop());
            result = result.next;
        }
        return node.next;
    }
}



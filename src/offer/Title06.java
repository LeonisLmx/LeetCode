package offer;

import java.util.Stack;

/**
 * @Author: Urey
 * @Date: 2020/12/10
 */
public class Title06 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int  x){ val = x;}
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int s = 0,n = 0;
        while (head != null){
            s++;
            stack.push(head.val);
            head = head.next;
        }
        int[] a = new int[s];
        while (n < s){
            a[n] = stack.pop();
            n++;
        }
        return a;
    }
}

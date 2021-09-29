package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/9/2
 */
public class Offer22 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public ListNode getKthFromEnd(ListNode head,int k){
        List<ListNode> list = new LinkedList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() - k);
    }
}

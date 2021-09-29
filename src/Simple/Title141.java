package Simple;

/**
 * @Author: Urey
 * @Date: 2021/8/23
 */
public class Title141 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head){
        ListNode a = head,b = head;
        while (a != null){
            a = a.next;
            if (b.next == null){
                return true;
            }
            b = b.next.next;
            if (a == b){
                return true;
            }
        }
        return false;
    }
}

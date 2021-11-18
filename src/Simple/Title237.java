package Simple;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/2 10:20 上午
 */
public class Title237 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

package Simple;

/**
 * @Author: Urey
 * @Date: 2021/3/26
 */
public class Title83 {

    public class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head){
        if (head == null){
            return null;
        }
        ListNode node = new ListNode(0),resultNode = node;
        int last = head.val,count = 0;
        while (head.next != null){
            head = head.next;
            if (last != head.val){
                node.next = new ListNode(last);
                node = node.next;
                last = head.val;
                count++;
            }
        }
        if (node.val != last || count == 0){
            node.next = new ListNode(last);
        }
        return resultNode.next;
    }
}

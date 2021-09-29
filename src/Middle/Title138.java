package Middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/7/22
 */
public class Title138 {

    static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node,Node> map = new HashMap<Node,Node>();

    public Node copyRandomList(Node head){
        if (head == null){
            return null;
        }
        if (!map.containsKey(head)){
            Node node = new Node(head.val);
            map.put(head,node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node node = new Node(7);
        Node param = node;
        node.next = new Node(13);
        node = node.next;
        node.next = new Node(11);
        node.random = param;
        node = node.next;
        node.next = new Node(10);
        node.random = new Node(1);
        node = node.next;
        node.next = new Node(1);
        node.random = new Node(11);
        node = node.next;
        node.random = new Node(7);
        Title138 title138 = new Title138();
        System.out.println(title138.copyRandomList(param));
    }
}

package Middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/9/23
 */
public class Title725 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val,ListNode next) { this.val = val; this.next = next;}
    }

    public ListNode[] splitListToParts(ListNode head,int k){
        List<Integer> listNodeList = new ArrayList<>();
        while (head != null){
            listNodeList.add(head.val);
            head = head.next;
        }
        int size = listNodeList.size();
        // 平均每个要有m个节点
        int m = size / k;
        // 前n个节点每个节点都1个节点
        int n = size % k;
        int index = 0;
        ListNode[] nodes = new ListNode[k];
        for (int i = 0;i < k;i++){
            ListNode resultNode = new ListNode(0);
            ListNode node = resultNode;
            for (int j = 0;j < m;j++){
                node.next = new ListNode(listNodeList.get(index));
                node = node.next;
                index++;
            }
            if (i < n){
                node.next = new ListNode(listNodeList.get(index));
                node = node.next;
                index++;
            }
            System.out.println(resultNode.toString());
            nodes[i] = resultNode.next;
        }
        return nodes;
    }
}

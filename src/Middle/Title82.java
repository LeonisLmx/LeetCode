package Middle;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: Urey
 * @Date: 2021/3/25
 */
public class Title82 {

    static class ListNode{
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head){
        Map<Integer,Integer> map = new HashMap<>();
        if (head == null){
            return null;
        }
        map.put(head.val,1);
        while (head.next != null){
            head = head.next;
            map.merge(head.val,1, Integer::sum);
        }
        ListNode node = new ListNode(0),resultNode = node;
        Set<Integer> set = map.keySet().stream().sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toCollection(LinkedHashSet::new));
        for (Integer integer : set) {
            if (map.get(integer) == 1){
                node.next = new ListNode(integer);
                node = node.next;
            }
        }
        return resultNode.next;
    }

    public ListNode deleteDuplicates2(ListNode head){
        if (head == null){
            return null;
        }
        ListNode node = new ListNode(0),resultNode = node;
        int temp = head.val,count = 0;
        while (head.next != null){
            head = head.next;
            if (temp == head.val){
                count++;
            }else if (count == 0){
                node.next = new ListNode(temp);
                node = node.next;
            }else{
                count = 0;
            }
            temp = head.val;
        }
        if (count == 0){
            node.next = new ListNode(temp);
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        Title82 title82 = new Title82();
        ListNode listNode = new ListNode(-3);
        listNode.next = new ListNode(-1);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(0);
        listNode.next.next.next.next = new ListNode(0);
        listNode.next.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next.next = new ListNode(3);
        ListNode node = title82.deleteDuplicates2(listNode);
        System.out.println(node.val);
        while (node.next != null){
            node = node.next;
            System.out.println(node.val);
        }
    }
}

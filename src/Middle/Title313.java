package Middle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: Urey
 * @Date: 2021/8/9
 */
public class Title313 {

    // 第一个数字 primes[0] 第二个数 primes[0] * primes[0] || primes[1] 第三个数
    public int nthSuperUglyNumber(int n,int[] primes){
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.offer(1L);
        int last = 0;
        for (int i = 0;i < n;i++){
            long cur = heap.poll();
            last = (int)cur;
            for (int prime : primes) {
                long next = cur * prime;
                if (set.add(next)){
                    heap.offer(next);
                }
            }
        }
        return last;
    }

    public int repeatNode(Node node){
        Set<Node> set = new HashSet<>();
        while (node.next != null){
            if (!set.add(node)){
                return node.val;
            }
            node = node.next;
        }
        return 0;
    }

    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Title313 title313 = new Title313();
        //System.out.println(title313.nthSuperUglyNumber(12,new int[]{2,7,13,19}));
//        PriorityQueue<Integer> set = new PriorityQueue<>();
//        set.offer(2);
//        set.offer(10);
//        set.offer(5);
//        set.offer(4);
//        System.out.println(set.toString());
//        set.remove((Object)4);
//        set.offer(3);
//        System.out.println(set.toString());
//        Node node = new Node(1);
//        Node a = node;
//        Node b = null;
//        for (int i = 2;i <= 11;i++){
//            if (i == 6) {
//                node.next = new Node(i);
//                node = node.next;
//                b = node;
//            }
//        }
//        node.next = b;
//        System.out.println(title313.repeatNode(a));
//        FileInputStream file = new FileInputStream("/Users/data.xls");
//        System.out.println("-----");
        FileInputStream files = new FileInputStream("/Users/liumingxin/Downloads/data.xls");
        System.out.println("......");
    }
}

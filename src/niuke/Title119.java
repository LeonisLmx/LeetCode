package niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Urey
 * @Date: 2021/8/20
 */
public class Title119 {

    public ArrayList<Integer> getLeastNumbers_Solution(int[] input,int k){
        if (k == 0){
            return new ArrayList<>();
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i : input) {
            if (queue.size() == k){
                if (i < queue.peek()){
                    queue.poll();
                    queue.offer(i);
                }
            }else{
                queue.offer(i);
            }
        }
        return new ArrayList<>(queue);
    }
}

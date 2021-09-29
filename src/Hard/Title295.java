package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Urey
 * @Date: 2021/8/27
 */
public class Title295 {

    Queue<Integer> minQueue;
    Queue<Integer> maxQueue;
    public Title295(){
        minQueue = new PriorityQueue<>((a , b) -> b - a);
        maxQueue = new PriorityQueue<>();
    }

    public void addNum(int num){
        if (minQueue.isEmpty() || num <= minQueue.peek()){
            minQueue.offer(num);
            if (minQueue.size() > maxQueue.size() + 1){
                maxQueue.offer(minQueue.poll());
            }
        }else{
            maxQueue.offer(num);
            if (minQueue.size() < maxQueue.size()){
                minQueue.offer(maxQueue.poll());
            }
        }
    }

    public double findMedian(){
        if (minQueue.size() == maxQueue.size()){
            return (minQueue.peek() + maxQueue.peek()) / 2.0;
        }else{
            return minQueue.peek() / 1.0;
        }
    }
}

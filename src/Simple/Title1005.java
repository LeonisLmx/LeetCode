package Simple;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author urey.liu
 * @description
 * @date 2021/12/3 10:48 上午
 */
public class Title1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            sum += num;
        }
        while (k > 0){
            sum -= queue.peek();
            sum += -queue.peek();
            queue.offer(-queue.poll());
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}

package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: Urey
 * @Date: 2021/2/3
 */
public class Title480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length,index = 0,i = 0;
        double[] doubles = new double[n - k + 1];
        Deque<Integer> queue = new LinkedBlockingDeque<>();
        while (index < n){
            while (queue.size() < k){
                queue.offer(nums[index]);
                index++;
            }
            List<Integer> list = new ArrayList<>(queue);
            Collections.sort(list);
            doubles[i] = k % 2 == 0?((double)list.get(k / 2) + (double)list.get((k - 1) / 2)) / 2:list.get(k / 2);
            queue.poll();
            i++;
        }
        return doubles;
    }

    public static void main(String[] args) {
//        Title480 title480 = new Title480();
//        System.out.println(Arrays.toString(title480.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(title480.medianSlidingWindow(new int[]{1, 4, 2, 3}, 4)));
//        System.out.println(Arrays.toString(title480.medianSlidingWindow(new int[]{2147483647,2147483647},2)));
        System.out.println(0 & 8);
    }
}

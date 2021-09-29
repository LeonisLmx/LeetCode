package Middle;

import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Author: Urey
 * @Date: 2021/9/3
 */
public class Title17_14 {

    public static int[] smallestK(int[] arr,int k){
        int[] arrs = new int[k];
        if (k == 0){
            return arrs;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        queue.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println(queue.toString());
        for (int i = 0; i < k; i++) {
            arrs[i] = queue.poll();
        }
        return arrs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }
}

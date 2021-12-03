package Hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/29 3:19 下午
 * arr = [1,2,3,5], k = 3
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 */
public class Title786 {

    public static int[] kthSmallestPrimeFraction(int[] arr,int k){
        int right = arr.length;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> (float)o1[0] / o1[1] < (float) o2[0] / o2[1] ?-1:1);
        for (int i = 0;i < right - 1;i++){
            for (int j = i + 1;j < right;j++){
                queue.offer(new int[]{arr[i],arr[j]});
            }
        }
        while (k > 1){
            queue.poll();
            k--;
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        StringBuilder sb = new StringBuilder("");
        for (int i = 1;i <= 31;i++){
            sb.append("1");
        }
        System.out.println(Integer.parseInt(sb.toString(),2));
        long value = 24114131L;
        System.out.println(Long.toBinaryString(value));
        System.out.println(Long.bitCount(value));
        value += Math.pow(2,2);
        System.out.println(Long.toBinaryString(value));
        System.out.println(Long.bitCount(value));
        System.out.println(Long.MAX_VALUE);
    }
}

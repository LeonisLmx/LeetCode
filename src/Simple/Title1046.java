package Simple;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1，1，2，4，7，8,9
 * @Author: Urey
 * @Date: 2020/12/30
 * 2，7，4，1，8，1
 * 1，1，2，4，7，8
 * 0，2，1
 * 0，1，2
 * 1
 */
public class Title1046 {

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0){
            return 0;
        }
        if (stones.length < 2){
            return stones[0];
        }
        int length = stones.length;
        revert(stones,length);
        return stones[length - 1];
    }

    private void revert(int[] stones,int length) {
        Arrays.sort(stones);
        System.out.println(Arrays.toString(stones));
        if (stones[length - 2] == 0){
            return;
        }
        stones[length - 1] = stones[length - 1] - stones[length - 2];
        stones[length - 2] = 0;
        revert(stones,length);
    }

    public static void main(String[] args) {
        Title1046 title1046 = new Title1046();
//        System.out.println(title1046.lastStoneWeight(new int[]{2,7,4,1,8,1,9}));
//        System.out.println(title1046.lastStoneWeight(new int[]{3,7,8}));
//        System.out.println(title1046.lastStoneWeight(new int[]{9,3,2,10}));
//        System.out.println(title1046.lastStoneWeight(new int[]{316,157,73,106,771,828,46,212,926,604,600,992,71,51,477,869,425,405,859,924,45,187,283,590,303,66,508,982,464,398}));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(2);
        queue.offer(7);
        queue.offer(4);
        queue.offer(1);
        queue.offer(8);
        queue.offer(1);
        queue.offer(9);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}

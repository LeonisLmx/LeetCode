package Middle;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author urey.liu
 * @description
 * @date 2022/1/20 10:34 上午
 * [5,1,2,4,3]
 * 1 -> 5   A   true
 * 2 -> 2   B   false
 * 3 -> 1   A   true
 * 4 -> 3   B   false
 * 5 -> 4   A   sum % 3 == 0 false /  第N个回合肯定是false
 */
public class Title2029 {

    public static boolean stoneGameIX(int[] stones){
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int val : stones) {
            int type = val % 3;
            if (type == 0) {
                ++cnt0;
            } else if (type == 1) {
                ++cnt1;
            } else {
                ++cnt2;
            }
        }
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        return Math.abs(cnt1 - cnt2) > 2;
    }

    public static void main(String[] args) {
//        System.out.println(stoneGameIX(new int[]{0,2,2,2,5}));
//        System.out.println(stoneGameIX(new int[]{2,1}));
//        System.out.println(stoneGameIX(new int[]{2}));
//        System.out.println(stoneGameIX(new int[]{5,1,2,4,3}));
//        System.out.println(stoneGameIX(new int[]{2,3}));
//        System.out.println(stoneGameIX(new int[]{20,3,20,17,2,12,15,17,4}));
        System.out.println(stoneGameIX(new int[]{1,1,7,10,8,17,10,20,2,10}));
    }
}

package Hard;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/9/30
 */
public class Title517 {

    public int findMinMoves(int[] machines){
        int total = Arrays.stream(machines).sum();
        if (total % machines.length > 0){
            return -1;
        }
        int ret = 0,sum = 0;
        // 平均数
        int avg = total / machines.length;
        for (int machine : machines) {
            machine -= avg;
            sum += machine;
            ret = Math.max(ret,Math.max(Math.abs(sum),machine));
        }
        return ret;
    }

    public static void main(String[] args) {
        Title517 title517 = new Title517();
//        System.out.println(title517.findMinMoves(new int[]{0,3,0}));
//        System.out.println(title517.findMinMoves(new int[]{4,0,0,4}));
        System.out.println(title517.findMinMoves(new int[]{0,0,11,5}));
    }
}

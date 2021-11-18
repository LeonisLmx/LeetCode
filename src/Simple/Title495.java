package Simple;

import java.util.Random;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/10 10:08 上午
 */
public class Title495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = duration;
        for (int i = 0;i < timeSeries.length - 1;i++){
            res += Math.min(duration,timeSeries[i + 1] - timeSeries[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int randomEnd = 120000,randomStart = 60000;
        long duration = new Random().nextInt( randomEnd - randomStart + 1) + randomStart;
        System.out.println(duration);
    }
}

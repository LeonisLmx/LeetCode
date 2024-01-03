package Middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author urey.liu
 * @description
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 * @date 2023/2/14 3:32 下午
 */
public class Title1124 {

    public static int longestWPI(int[] hours) {
        int res = 0;
        for (int l = 0;l < hours.length;l++){
            int a = 0,b = 0,r = l;
            while (r < hours.length) {
                if (hours[r] > 8) {
                    a++;
                } else {
                    b++;
                }
                if (a > b){
                    res = Math.max(res, r - l + 1);
                }
                r++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

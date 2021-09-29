package Hard;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @Author: Urey
 * @Date: 2021/6/18
 */
public class Title483 {

    public String smallestGoodBase(String n) {
        int len = n.length() + 1,start = 2;
        int max = (int)(Math.log(Long.parseLong(n)) / Math.log(2) + 1);
        while (len >= 3){
            while (start <= 60) {
                int sum = 1, count = max;
                while (true) {
                    sum += Math.pow(start, count);
                    count--;
                    if (sum == Long.parseLong(n) && count == 0) {
                        return start + "";
                    } else if (sum > Long.parseLong(n) || count == 0) {
                        break;
                    }
                }
                start++;
            }
            len--;
        }
        return Long.parseLong(n) - 1 + "";
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(12));
        //System.out.println(Integer.toBinaryString(1) ^ Integer.toBinaryString(2));
    }
}

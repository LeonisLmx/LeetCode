package Middle;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Urey
 * @Date: 2021/6/11
 */
// dp[7] = dp[4] + dp[3]
// dp[8] = dp[4] + dp[4]
// dp[10] = dp[9] + dp[1]
public class Title279 {

    public int numSquares(int n){
        int[] dp = new int[n + 1];
        for (int i = 1;i <= n;i ++){
            double s = Math.sqrt(i);
            if (i % s == 0){
                dp[i] = 1;
            }else {
                int m = (int) s;
                dp[i] = Integer.MAX_VALUE;
                while (m > 0){
                    dp[i] = Math.min(dp[i],dp[m * m] + dp[i - m * m]);
                    m--;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-5 >> 2));
        System.out.println(Integer.toBinaryString(-5 >>> 2));
        System.out.println(1 << 30);
        System.out.println(Integer.toBinaryString(1 << 30));
        System.out.println(1073741824 >>> 30);
        System.out.println(Integer.toBinaryString(1073741824 >>> 30));
        System.out.println(Integer.toBinaryString(1073741824 >> 30));
    }
}

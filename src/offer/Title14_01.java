package offer;

/**
 * @Author: Urey
 * @Date: 2021/1/4
 * 2 -> 1
 * 3 -> 2
 * 4 -> 2 * 2
 * 5 -> 2 * 3
 * 6 -> 3 * 3
 * 7 -> 2 * 3 * 2
 * 8 -> 2 * 3 * 3
 * dp[n] = dp[n - 3] * 3
 */
public class Title14_01 {

    public int cuttingRope(int n) {
        if (n <= 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        long[] dp = new long[n + 1];
        dp[2] = 2;dp[3] = 3;dp[4] = 4;
        for (int k = 5;k <= n;k++){
            dp[k] = Math.floorMod(dp[k - 3] * 3,1000000007);
        }
        return (int)dp[n];
    }

    public static void main(String[] args) {
        Title14_01 title14_01 = new Title14_01();
        System.out.println(title14_01.cuttingRope(120));
        System.out.println(title14_01.cuttingRope(8));
    }
}

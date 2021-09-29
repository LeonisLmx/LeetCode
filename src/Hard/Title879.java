package Hard;

/**
 * @Author: Urey
 * @Date: 2021/6/9
 */
// 10个人完成M个项目的最大产值
// dp[n][m] = Math.max(dp[n - 1][m],dp[n][m])
public class Title879 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int num = group.length;
        int[] dp = new int[num + 1];
        for (int i = 1; i < profit.length; i++) {
            if (profit[i] >= minProfit && group[i] <= n){
                dp[i] += 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(4));
        System.out.println(Math.sqrt(8));
        System.out.println(Math.sqrt(16));
        System.out.println(Math.sqrt(20));
    }
}

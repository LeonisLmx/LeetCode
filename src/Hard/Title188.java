package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Urey
 * @Date: 2020/12/28
 * 操作要么持有，要么卖出
 * 0 不持有
 * dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1] + prices[i])
 * 1 持有
 * dp[1][i] = Math.max(dp[1][i-1],dp[0][i-1] - prices[i])
 * dp[k] = dp[k - 1] + n;
 */
public class Title188 {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = buy[0][0];
            sell[0][i] = sell[0][0];
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                // 要么是昨天有股票，今天不买入；要么是昨天没有股票，今天买入
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                // 要么是昨天卖出了，今天没股票；要么是昨天买入（昨天买入说明次数要减1，买入时候计算次数），今天卖出
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }

    public int maxProfit2(int k, int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int[][] dp = new int[2][prices.length];
        List<Integer> list = new ArrayList<>();
        dp[0][0] = 0;
        dp[1][0] = -prices[0];
        for (int i = 1;i < prices.length;i++){
            if (dp[0][i-1] < dp[1][i-1] + prices[i]){
                if (list.size() == 0){
                    list.add(-prices[0]);
                }
                list.add(prices[i]);
            }
            dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1] + prices[i]);
            if (dp[1][i - 1] < dp[0][i-1] - prices[i]){
                list.add(prices[i]);
            }
            dp[1][i] = Math.max(dp[1][i-1],dp[0][i-1] - prices[i]);
        }
        return dp[0][prices.length - 1];
    }

    public static void main(String[] args) {
        Title188 title188 = new Title188();
//        System.out.println(title188.maxProfit(2,new int[]{2,4,1}));
//        System.out.println(title188.maxProfit(2,new int[]{3,2,6,5,0,3}));
        System.out.println(title188.maxProfit(2,new int[]{3,3,5,0,0,3,2,4}));
    }
}

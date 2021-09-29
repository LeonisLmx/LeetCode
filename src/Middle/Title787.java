package Middle;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/8/24
 */
public class Title787 {

    // dp[dst][k] = Math.min(dp[dst][k - 1],dp[a....b][k - 1])
    public int findCheapestPrice(int n,int[][] flights,int src,int dst,int k){
        final int INF = 10000 * 101 + 1;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        Title787 title787 = new Title787();
        System.out.println(title787.findCheapestPrice(3,new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,1));
        System.out.println(title787.findCheapestPrice(3,new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,0));
    }
}

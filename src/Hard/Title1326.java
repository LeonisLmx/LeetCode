package Hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author urey.liu
 * @description
 * @date 2023/2/23 5:18 下午
 */
public class Title1326 {

    public static int minTaps(int n, int[] ranges) {
        int[][] res = new int[n + 1][2];
        for (int i = 0;i <= n;i++){
            int[] ans = new int[2];
            ans[0] = Math.max(0, i - ranges[i]);
            ans[1] = Math.min(n, i + ranges[i]);
            res[i] = ans;
        }
        Arrays.sort(res, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0;i <= n; i++){
            int start = res[i][0], end = res[i][1];
            if (dp[start] == Integer.MAX_VALUE){
                return -1;
            }
            for (int j = start; j <= end; j++){
                dp[j] = Math.min(dp[j], dp[start] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minTaps(5,new int[]{3,4,1,1,0,0}));
        System.out.println(minTaps(7, new int[]{1,2,1,0,2,1,0,1}));
    }
}

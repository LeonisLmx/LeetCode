package Hard;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/5/13
 */
// 移动i步之后在j的位置上的所有结果
// dp[i][j] = dp[i - 1][j] + dp[i - 1][j + 1] + dp[i - 1][j - 1]
public class Title1269 {

    public int numWays(int steps, int arrLen) {
        int[][] ans = new int[steps + 1][arrLen + 1];
        Arrays.fill(ans[0],0);
        ans[0][0] = 1;
        for (int i = 1;i <= steps;i++){
            for (int j = 0;j < arrLen;j++){
                if (j == 0) {
                    ans[i][j] = (ans[i - 1][j] + ans[i - 1][j + 1]) % (10^9 + 7);
                }else {
                    ans[i][j] = (ans[i - 1][j] + ans[i - 1][j + 1] + ans[i - 1][j - 1])  % (10^9 + 7);
                }
            }
        }
        return ans[steps][0];
    }

    public static void main(String[] args) {
        Title1269 title1269 = new Title1269();
        System.out.println(title1269.numWays(3,2));
        System.out.println(title1269.numWays(2,4));
        System.out.println(title1269.numWays(4,2));
        System.out.println(title1269.numWays(6,13));
    }
}

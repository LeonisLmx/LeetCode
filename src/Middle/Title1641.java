package Middle;

import java.util.Arrays;

/**
 * @author urey.liu
 * @description "a" "e" "i" "o" "u"
 * 1  5
 * 2  5 + 4 + 3 + 2 + 1 = 15
 * 3  15
 * @date 2023/3/29 11:24 上午
 */
public class Title1641 {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];
        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= 5;j++){
                if (j == 1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return Arrays.stream(dp[n]).sum();
    }
}

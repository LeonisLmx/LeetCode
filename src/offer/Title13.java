package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Urey
 * @Date: 2021/1/4
 */
public class Title13 {
    Set<String> resultSet = new HashSet<>();
    boolean[][] dp;

    public int movingCount(int m, int n, int k) {
        this.dp = new boolean[m + 1][n + 1];
        return move(0,0,k,m,n);
    }

    private int move(int x, int y, int k, int m, int n) {
        if (x < 0 || y < 0 || x > m - 1 || y > n - 1 || dp[x][y]) {
            return 0;
        }
        dp[x][y] = true;
        if (x / 10 + x % 10 + y / 10 + y % 10 <= k) {
            return 1 + move(x + 1, y, k, m, n) + move(x, y + 1, k, m, n);
        }
        return 0;
    }

    public static void main(String[] args) {
        Title13 title13 = new Title13();
        System.out.println(title13.movingCount(16,8,4));
    }
}

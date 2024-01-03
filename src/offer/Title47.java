package offer;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/8 2:50 下午
 */
public class Title47 {

    public int maxValue(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0 ;j < n;j++){
                if (i == 0){
                    if (j == 0){
                        dp[0][0] = grid[0][0];
                    }else{
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                }else{
                    if (j == 0){
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    }else{
                        dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Title47 title47 = new Title47();
        System.out.println(title47.maxValue(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}

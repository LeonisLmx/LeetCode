package Simple;

/**
 * @Author: Urey
 * @Date: 2021/9/18
 * dp[0][1] = dp[0][2] = dp[0][3] = true
 * dp[1][1] = dp[1][1] = dp[1][1] = false
 * dp[0][4] = false
 * dp[1][4] = true
 * dp[0][5] = dp[1][2] || dp[1][3] || dp[1][4]
 * dp[1][5] = dp[0][2] && dp[0][3] && dp[0][4]
 * */
public class Title292 {

    public boolean canWinNim(int n){
//        boolean[][] dp = new boolean[2][n + 1];
//        for (int i = 0;i <= n;i++){
//            if (i < 4){
//                dp[0][i] = true;
//                dp[1][i] = false;
//            }else{
//                dp[0][i] = dp[1][i - 1] || dp[1][i - 2] || dp[1][i - 3];
//                dp[1][i] = dp[0][i - 1] && dp[0][i - 2] && dp[0][i - 3];
//            }
//        }
//        return dp[0][n];
        return n % 4 > 0;
    }

    public static void main(String[] args) {
        Title292 title292 = new Title292();
        for (int i = 4;i <= 20;i++) {
            System.out.println(i + " " +title292.canWinNim(i));
        }
    }
}

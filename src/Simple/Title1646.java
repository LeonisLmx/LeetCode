package Simple;

/**
 * @Author: Urey
 * @Date: 2021/8/23
 */
public class Title1646 {

    public static int getMaximumGenerated(int n){
        if (n <= 1){
            return n;
        }
        int max = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2;i <= n;i++){
            if (i % 2 == 0){
                dp[i] = dp[i / 2];
            }else{
                int a = i / 2;
                dp[i] = dp[a] + dp[a + 1];
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
    }
}

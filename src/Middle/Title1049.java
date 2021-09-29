package Middle;

/**
 * @Author: Urey
 * @Date: 2021/6/9
 */
public class Title1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0,max;
        for (int stone : stones) {
            sum += stone;
        }
        max = sum / 2;
        int[][] dp = new int[stones.length + 1][max + 1];
        for (int i = 1; i <= stones.length; i++) {
            int temp = stones[i - 1];
            for (int j = 0;j <= max;j++){
                dp[i][j] = dp[i - 1][j];
                if (j >= temp){
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - temp] + temp);
                }
            }
        }
        return Math.abs(sum - dp[stones.length][max] - dp[stones.length][max]);
    }

    public static void main(String[] args) {
        Title1049 title1049 = new Title1049();
        System.out.println(title1049.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
        System.out.println(title1049.lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
}

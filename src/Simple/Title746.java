package Simple;

/**
 * @Author: Urey
 * @Date: 2020/12/21
 * dp[m] = min[dp[m - 1],dp[m - 2]]
 */
public class Title746 {

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length  < 2){
            return 0;
        }
        int l = cost.length;
        int[] dp = new int[l];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2;i < l;i++){
            dp[i] = Math.min(dp[i - 1],dp[i - 2]) + cost[i];
        }
        return Math.min(dp[l - 1],dp[l - 2]);
    }

    public static int minCostClimbingStairs2(int[] cost) {
        if (cost.length  < 2){
            return 0;
        }
        int l = cost.length,step1  =  cost[0],step2 = cost[1];
        for (int i = 2;i < l;i++){
            int next = Math.min(step1,step2) + cost[i];
            step1 = step2;
            step2 = next;
        }
        return Math.min(step1,step2);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs2(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs2(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}

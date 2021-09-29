package Middle;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/4/15
 */
public class Title213 {

    // dp[m] = Math.max(dp[m - 2] + nums[m],dp[m - 1])
    // 要么偷这家，要么不偷
    // 二维数组，0带表不偷这家，1代表偷这家
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[][] dp = new int[2][nums.length];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        // a 代表不偷当前家，b代表偷当前家
        StringBuilder a = new StringBuilder(""),b = new StringBuilder(""),temp = new StringBuilder("");
        b.append(0);
        for (int i = 1;i < nums.length;i++){
            temp = new StringBuilder(a);
            // 如果不偷这家，那最大值就是前面的偷或者不偷的最大值
            if (dp[1][i - 1] > dp[0][i - 1]){
                //  偷前面那家，不偷当前的
                dp[0][i] = dp[1][i - 1];
                a = new StringBuilder(b);
            }else{
                // 前面那家也不偷，当前也不偷
                dp[0][i] = dp[0][i - 1];
            }
            // 如果偷这家，那前面一家肯定不能偷，那么就是前面一家不偷的情况 + 当前的数值
            dp[1][i] = dp[0][i - 1] + nums[i];
            b = new StringBuilder(temp);
            b.append(i);
        }
        System.out.println(a.toString());
        System.out.println(b.toString());
        // 如果偷最后一家，要看下b里面是否包含0
        if (dp[1][nums.length - 1] > dp[0][nums.length - 1]){
            if ("0".equals(b.substring(0,1))){
                return Math.max(dp[0][nums.length - 1],Math.max(dp[0][nums.length - 2],dp[1][nums.length - 2]));
            }
        }
        return Math.max(dp[0][nums.length - 1],dp[1][nums.length - 1]);
    }

    public static void main(String[] args) {
        Title213 title213 = new Title213();
//        System.out.println(title213.rob(new int[]{2,3,2}));
//        System.out.println(title213.rob(new int[]{1,2,3,1}));
        System.out.println(title213.rob(new int[]{1,1,1,2}));
    }
}

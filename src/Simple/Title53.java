package Simple;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/8/24
 */
public class Title53 {

    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1;i < nums.length;i++){
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}

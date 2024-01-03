package Middle;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/10 5:53 下午
 */
public class Title1590 {

    public int minSubarray(int[] nums, int p) {
        int length = nums.length;
        long[] dp = new long[length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        if (dp[length - 1] % p == 0){
            return 0;
        }
        for (int i = 1;i < length;i++){
            for (int j = 0;j <= length - i;j++){
                long res = j > 0?dp[j - 1]:0;
                if ((dp[length - 1] - (dp[j + i - 1] - res)) % p == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Title1590 title1590 = new Title1590();
        System.out.println(title1590.minSubarray(new int[]{3,1,4,2},6));
        System.out.println(title1590.minSubarray(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2},148));
        System.out.println(title1590.minSubarray(new int[]{17,6,22,31,25,4,18,32,18,26,2,31,26,8,12,2},142));
    }
}

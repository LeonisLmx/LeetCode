package Middle;

import java.util.*;

/**
 * @author urey.liu
 * @description
 * @date 2022/2/9 2:08 下午
 * [3,4,2] -> 6
 * [2,2,3,3,3,4] -> 9
 * dp[0] = 8,dp[1] = 8,dp[2] = Math.max(dp[0] + res[2],dp[1]),dp[3] = Math.max(dp[0],dp[1]) + res[3]
 * dp[m] = Math.max(dp[m - 2],dp[m - 3]) + res[m]
 */
public class Title740 {

    public static int deleteAndEarn(int[] nums){
        Map<Integer,Integer> cnt = new HashMap<>();
        int res = 0,max = 0;
        for (int num : nums) {
            cnt.merge(num,num,Integer::sum);
            max = Math.max(max,num);
        }
        int[] arr = new int[max];

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
//        System.out.println(deleteAndEarn(new int[]{2,3,4}));
//        // 37
//        System.out.println(deleteAndEarn(new int[]{8,10,4,9,1,3,5,9,4,10}));
//        // 61
//        System.out.println(deleteAndEarn(new int[]{8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4}));
//        // 66
//        System.out.println(deleteAndEarn(new int[]{3,7,10,5,2,4,8,9,9,4,9,2,6,4,6,5,4,7,6,10}));
        int[] res = new int[]{1,8,5,9,6,9,4,1,7,3,3,6,3,3,8,2,6,3,2,2,1,2,9,8,7,1,1,10,6,7,3,9,6,10,5,4,10,1,6,7,4,7,4,1,9,5,1,5,7,5};
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
        System.out.println(deleteAndEarn(new int[]{1,8,5,9,6,9,4,1,7,3,3,6,3,3,8,2,6,3,2,2,1,2,9,8,7,1,1,10,6,7,3,9,6,10,5,4,10,1,6,7,4,7,4,1,9,5,1,5,7,5}));
    }
}

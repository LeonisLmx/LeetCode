package Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/8/11
 */
public class Title446 {

    public int numberOfArithmeticSlices(int[] nums){
        int length = nums.length,result = 0;
        if (length < 3){
            return 0;
        }
        Map<Long,Integer>[] dp = new HashMap[length];
        for (int i = 0;i < length;i++){
            dp[i] = new HashMap<>();
        }
        for (int i = 1;i < length;i++){
            for (int j = 0;j < i;j++){
                long diff = (long)nums[i] - nums[j];
                dp[i].put(diff,dp[i].getOrDefault(diff,0) + dp[j].getOrDefault(diff,0) + 1);
                if (dp[j].containsKey(diff)){
                    result += dp[j].get(diff);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Title446 title446 = new Title446();
//        System.out.println(title446.numberOfArithmeticSlices(new int[]{2,4,6,8,10}));
//        System.out.println(title446.numberOfArithmeticSlices(new int[]{7,7,7,7,7}));
//        System.out.println(title446.numberOfArithmeticSlices(new int[]{0,1,2,2,2}));
        System.out.println(title446.numberOfArithmeticSlices(new int[]{0,2000000000,-294967296}));
        //System.out.println(title446.numberOfArithmeticSlices(new int[]{79,20,64,28,67,81,60,58,97,85,92,96,82,89,46,50,15,2,36,44,54,2,90,37,7,79,26,40,34,67,64,28,60,89,46,31,9,95,43,19,47,64,48,95,80,31,47,19,72,99,28,46,13,9,64,4,68,74,50,28,69,94,93,3,80,78,23,80,43,49,77,18,68,28,13,61,34,44,80,70,55,85,0,37,93,40,47,47,45,23,26,74,45,67,34,20,33,71,48,96}));
    }
}

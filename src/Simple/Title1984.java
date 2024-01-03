package Simple;

import java.util.Arrays;

/**
 * @author urey.liu
 * @description
 * @date 2022/2/11 5:49 下午
 */
public class Title1984 {

    public int minimumDifference(int[] nums, int k) {
        if (k == 1){
            return 0;
        }
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = k - 1;i < nums.length;i++){
            res = Math.min(res,nums[i] - nums[i - k + 1]);
        }
        return res;
    }
}

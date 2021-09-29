package Middle;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/7/20
 */
public class Title1877 {

    public int minPairSum(int[] nums){
        Arrays.sort(nums);
        int len = nums.length,i = 0,j = len - 1,max = 0;
        while (i < j){
            max = Math.max(nums[i] + nums[j],max);
            i++;j--;
        }
        return max;
    }
}

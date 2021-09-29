package Middle;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/9/15
 */
public class TItle162 {

    public int findPeakElement(int[] nums){
        if (nums.length == 1){
            return 0;
        }
        for (int i = 0;i < nums.length;i++){
            if (i == 0 && nums[i] > nums[i + 1]){
                return 0;
            }else if (i == nums.length - 1 && nums[i] > nums[i - 1]){
                return nums.length - 1;
            }else if (i > 0 && i < nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                return i;
            }
        }
        return 0;
    }
}

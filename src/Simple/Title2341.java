package Simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * @date 2023/2/16 1:50 下午
 */
public class Title2341 {

    public int[] numberOfPairs(int[] nums) {
        int res = 0,length = 0,i = 0;
        Arrays.sort(nums);
        while (i <= nums.length - 1){
            if (i == nums.length - 1){
                length++;
                break;
            }
            if (nums[i] == nums[i + 1]){
                i = i + 2;
                res++;
            }else{
                i = i + 1;
                length++;
            }
        }
        return new int[]{res, length};
    }
}

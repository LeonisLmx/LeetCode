package Simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/7/9
 */
public class Title17D10 {

    public int majorityElement(int[] nums){
        int len = nums.length,mid = (len + 1)/2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < len;i++){
            if (map.merge(nums[i],1,Integer::sum) >= mid){
                return nums[i];
            }
        }
        return -1;
    }

    public int majorityElements(int[] nums){
        int count = 0,index = -1,countNum = 0,len = nums.length;
        for (int i = 0;i < len;i++){
            if (count == 0){
                index = nums[i];
                count++;
            }else {
                count = index == nums[i]?count + 1:count - 1;
            }
        }
        for (int i = 0;i < len;i++){
            if (index == nums[i]){
                countNum++;
                if (countNum * 2 >= len + 1){
                    return index;
                }
            }
        }
        return -1;
    }
}

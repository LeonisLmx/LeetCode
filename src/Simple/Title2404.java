package Simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * @date 2023/4/13 2:07 下午
 */
public class Title2404 {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0,ans = 0,i = 0;
        while (i + count < nums.length){
            if (nums[i] % 2 == 0){
                map.merge(nums[i], 1, Integer::sum);
                if (map.get(nums[i]) >= count && nums[i] < ans){
                    count = map.get(nums[i]);
                    ans = nums[i];
                }else if (map.get(nums[i]) > count){
                    count = map.get(nums[i]);
                    ans = nums[i];
                }
            }
            i++;
        }
        return ans;
    }
}

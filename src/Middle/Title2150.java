package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/30 4:47 下午
 */
public class Title2150 {

    public static List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0;i < length;i++){
            if (i == 0){
                if (nums[i + 1] - nums[i] > 1){
                    list.add(nums[i]);
                }
            }else if (i == length - 1){
                if (nums[i] - nums[i - 1] > 1){
                    list.add(nums[i]);
                }
            }else {
                if (nums[i] - nums[i - 1] > 1 && nums[i + 1] - nums[i] > 1) {
                    list.add(nums[i]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findLonely(new int[]{75,35,59,66,69,53,37,16,60,98,11,33,3,85,59,65,59,44,34,89,72,47}));
    }
}

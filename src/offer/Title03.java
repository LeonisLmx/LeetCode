package offer;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2020/12/9
 */
public class Title03 {

    // 创建hash表，下标对应的是自己的值
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[nums[i]] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Title03 title03 = new Title03();
        System.out.println(title03.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}

package Hard;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2020/11/26
 */
public class Title164 {

    public int maximumGap(int[] nums){
        if (nums.length < 2){
            return 0;
        }
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            if (i > 0){
                min = Math.max(min,nums[i] - nums[i - 1]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Title164 title = new Title164();
        System.out.println(title.maximumGap(new int[]{10}));
    }
}

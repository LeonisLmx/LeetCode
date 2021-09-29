package Hard;

import java.util.Stack;

/**
 * @Author: Urey
 * @Date: 2020/12/3
 */
public class Title41 {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len ; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                swap(nums,i,nums[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1){
                return i+1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Title41 title41 = new Title41();
        System.out.println(title41.firstMissingPositive(new int[]{2,0,1}));
    }
}

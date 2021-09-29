package Simple;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/1/28
 */
public class Title724 {

    public int pivotIndex(int[] nums) {
        if (nums.length < 2){
            return -1;
        }
        int sum = Arrays.stream(nums).sum(),temp = 0;
        if (sum == nums[0]){
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            temp = temp + nums[i];
            if ((sum - nums[i + 1]) % 2 != 0){
                continue;
            }
            if (temp == (sum - nums[i + 1]) / 2){
                return i + 1;
            }
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        if (nums.length < 2){
            return -1;
        }
        int i = -1,j = nums.length,left = 0,right = 0;
        while (i != j - 2){
            if (left < right && nums[i + 1] >= 0){
                i++;
                left = left + nums[i];
            }else if (left < right && nums[i + 1] < 0){
                j--;
                right = right + nums[j];
            }else if (left >= right && nums[j - 1] >= 0){
                j--;
                right = right + nums[j];
            }else if (left >= right && nums[j - 1] < 0){
                i++;
                left = left + nums[i];
            }
        }
        return left == right?i + 1:-1;
    }

    public static void main(String[] args) {
        Title724 title724 = new Title724();
//        System.out.println(title724.pivotIndex2(new int[]{1, 7, 3, 6, 5, 6}));
//        System.out.println(title724.pivotIndex2(new int[]{-1,-1,-1,-1,-1,0}));
//        System.out.println(title724.pivotIndex2(new int[]{-1,-1,-1,0,-1,-1}));
//        System.out.println(title724.pivotIndex2(new int[]{-1,-1,-1,-1,-1,-1}));
//        System.out.println(title724.pivotIndex2(new int[]{-1,-1,-1,0,1,1}));
        System.out.println(title724.pivotIndex2(new int[]{-1,-1,0,-1,-1,0}));
    }
}

package Middle;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2020/12/1
 */
public class Title34 {

    public int[] searchRange(int[] nums, int target) {
        int[] a = new int[]{-1,-1};
        int min = -1,max = -1;
        for (int i = 0,j = nums.length-1; i <= j;) {
            if (target < nums[(i + j)/2]){
                j--;
            }else if (target > nums[(i+j) / 2]){
                i++;
            }else{
                min = max = (i + j)/2;
                break;
            }
        }
        if (min >  -1) {
            while (max  < nums.length && target == nums[max]) {
                a[1] = max;
                max++;
            }
            while (min >=  0 && target == nums[min]) {
                a[0] = min;
                min--;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Title34 title34 = new Title34();
        System.out.println(Arrays.toString(title34.searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println(Arrays.toString(title34.searchRange(new int[]{5,7,7,8,8,10},6)));
        System.out.println(Arrays.toString(title34.searchRange(new int[]{},6)));
        System.out.println(Arrays.toString(title34.searchRange(new int[]{1},1)));
    }
}

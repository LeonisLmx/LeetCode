package Middle;

import java.util.Arrays;

/**
 * @author urey.liu
 * @description
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 *
 * 用例可以保证存在这样的划分方法。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 *
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 *
 * @date 2022/10/24 3:46 下午
 */
public class Title915 {

    public static int partitionDisjoint(int[] nums) {
        int[] a = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int[] b = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < nums.length;i++){
            max = Math.max(max, nums[i]);
            a[i] = max;
        }
        for (int i = nums.length - 1;i >= 0;i--){
            min = Math.min(min, nums[i]);
            b[i] = min;
        }
        for (int i = 0;i < nums.length - 1;i++){
            if (a[i] <= b[i + 1]){
                return i + 1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(partitionDisjoint(new int[]{5,0,3,8,6}));
        System.out.println(partitionDisjoint(new int[]{1,1,1,0,6,12}));
    }
}

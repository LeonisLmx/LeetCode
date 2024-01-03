package Middle;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author urey.liu
 * @description
 * 给定一个整数数组nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 *
 *
 * 提示：
 *
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 每个元素的频率在 [1,4] 范围内
 *
 * 回溯？
 *
 * @date 2023/4/13 3:00 下午
 */
public class Title698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        return false;
    }

    public static void main(String[] args) {
        Title698 title698 = new Title698();
//        System.out.println(title698.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 1, 1, 1},4));
//        System.out.println(title698.canPartitionKSubsets(new int[]{1,2,3,4},3));
//        System.out.println(title698.canPartitionKSubsets(new int[]{1,2,3,6},3));
//        System.out.println(title698.canPartitionKSubsets(new int[]{1,2,3,3,2,1,1,1,1},3));
//        System.out.println(title698.canPartitionKSubsets(new int[]{1,1,1,1,1,1,1,1,1},3));
//        System.out.println(title698.canPartitionKSubsets(new int[]{2,5,5,5,1},2));
        System.out.println(title698.canPartitionKSubsets(new int[]{12,1,2,3,18,2,5,2,11,1}, 3));
    }
}

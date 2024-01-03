package Hard;

import java.util.*;

/**
 * @author urey.liu
 * @description
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
 *
 * 子数组 是数组中 连续 的一部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1], k = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/10/26 1:55 下午
 */
public class Title862 {

    public int shortestSubarray(int[] nums, int k) {
        int min = -1;
        int[] sums = new int[nums.length];
        for (int i = 0;i < nums.length;i++){
            if (nums[i] >= k){
                return 1;
            }
            if (i == 0){
                sums[i] = nums[i];
            }else {
                sums[i] = sums[i - 1] + nums[i];
            }
            if (sums[i] >= k && min == -1){
                // 和的最小值
                min = i + 1;
            }
        }
        for (int i = 0;i < sums.length - 1;i++){
            for (int j = i + 1;j < sums.length;j++){
                if (min > -1 && j - i >= min){
                    break;
                }
                if (sums[j] - sums[i] >= k){
                    min = j - i;
                    if (min == 2){
                        return 2;
                    }
                    break;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Title862 title862 = new Title862();
        System.out.println(title862.shortestSubarray(new int[]{1},1));
        System.out.println(title862.shortestSubarray(new int[]{1, 2},4));
        System.out.println(title862.shortestSubarray(new int[]{2, -1, 2},3));
        System.out.println(title862.shortestSubarray(new int[]{77,19,35,10,-14},19));
        System.out.println(title862.shortestSubarray(new int[]{48,99,37,4,-31},140));
        System.out.println(title862.shortestSubarray(new int[]{17,85,93,-45,-21},150));
        System.out.println(title862.shortestSubarray(new int[]{-28,81,-20,28,-29},89));
    }
}

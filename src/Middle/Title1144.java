package Middle;

import java.util.Arrays;

/**
 * @author urey.liu
 * @description
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 *
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 *
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 *
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 *
 * @date 2023/2/27 4:12 下午
 */
public class Title1144 {

    public int movesToMakeZigzag(int[] nums) {
        int length = nums.length;
        if (length == 1){
            return 0;
        }
        int res = 0, ans = 0;
        for (int i = 0;i < length;i++){
            // 取0，2,4为最小值
            if (i % 2 == 0){
                if (i == 0){
                    res += Math.max(0, nums[i] - nums[i + 1] + 1);
                } else if (i == length - 1){
                    res += Math.max(0, nums[i] - nums[i - 1] + 1);
                }else {
                    res += Math.max(0, nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1);
                }
            }else{
                // 取 0,2,4为最小值
                if (i == length - 1){
                    ans += Math.max(0, nums[i] - nums[i - 1] + 1);
                }else {
                    ans += Math.max(0, nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1);
                }
            }
        }
        return Math.min(res, ans);
    }

    public static void main(String[] args) {
        Title1144 title1144 = new Title1144();
        System.out.println(title1144.movesToMakeZigzag(new int[]{1}));
        System.out.println(title1144.movesToMakeZigzag(new int[]{1,2}));
        System.out.println(title1144.movesToMakeZigzag(new int[]{9,2}));
        System.out.println(title1144.movesToMakeZigzag(new int[]{1,2,3}));
        System.out.println(title1144.movesToMakeZigzag(new int[]{9,6,1,6,2}));
    }
}

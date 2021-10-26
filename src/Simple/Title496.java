package Simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author urey.liu
 * @description 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * @date 2021/10/26 11:02 上午
 */
public class Title496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums2.length;i++){
            for (int j = i + 1;j < nums2.length;j++){
                if (nums2[j] > nums2[i]){
                    map.put(nums2[i],nums2[j]);
                    break;
                }
            }
        }
        int[] arr = new int[nums1.length];
        for (int i = 0;i < arr.length;i++){
            arr[i] = map.getOrDefault(nums1[i],-1);
        }
        return arr;
    }
}

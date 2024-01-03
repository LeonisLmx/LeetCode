package Hard;

import java.util.Arrays;

/**
 * @author urey.liu
 * @description
 * 给你两个整数数组arr1 和 arr2，返回使arr1严格递增所需要的最小「操作」数（可能为 0）。
 *
 * 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为i 和j，0 <=i < arr1.length和0 <= j < arr2.length，然后进行赋值运算arr1[i] = arr2[j]。
 *
 * 如果无法让arr1严格递增，请返回-1。
 *
 *
 * 示例 1：
 *
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
 * 输出：1
 * 解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
 * 示例 2：
 *
 * 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
 * 输出：2
 * 解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
 * 示例3：
 *
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
 * 输出：-1
 * 解释：无法使 arr1 严格递增。
 * @date 2023/4/20 11:12 上午
 */
public class Title1187 {

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int j = 0;
        for (int i = 1;i < arr1.length;i++){
            if (arr1[i] <= arr1[i - 1]){
                while (j < arr2.length){
                    if (arr2[j] < arr1[i]){
                        if (i == 1){
                            arr1[i - 1] = arr2[j];
                            break;
                        }else if (arr1[i - 2] > arr1[j]){
                            arr1[i - 1] = arr2[j];
                            break;
                        }
                    }
                    j++;
                }
            }
        }
        return 0;
    }
}

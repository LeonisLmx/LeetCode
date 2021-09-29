package Middle;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/8/3
 */
public class Title581 {

    public int findUnsortedSubarray(int[] nums){
        int[] arr = Arrays.copyOf(nums,nums.length);;
        int start = -1,end = -1;
        Arrays.sort(arr);
        for (int i = 0,j = arr.length - 1;i < j;){
            if (start == -1) {
                if (nums[i] != arr[i]) {
                    start = i;
                }else {
                    i++;
                }
            }
            if (end == -1) {
                if (nums[j] != arr[j]) {
                    end = j;
                }else {
                    j--;
                }
            }
            if (start > -1 && end > -1){
                break;
            }
        }
        return end == start?0:end - start + 1;
    }

    public static void main(String[] args) {
        Title581 title581 = new Title581();
        System.out.println(title581.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        System.out.println(title581.findUnsortedSubarray(new int[]{2,1}));
        System.out.println(title581.findUnsortedSubarray(new int[]{5,4,3,2,1}));
        System.out.println(title581.findUnsortedSubarray(new int[]{1,3,2,4,5}));
    }
}

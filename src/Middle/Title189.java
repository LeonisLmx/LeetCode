package Middle;

import com.sun.crypto.provider.BlowfishKeyGenerator;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/1/8
 */
public class Title189 {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        while (k > 0) {
            int temp = nums[length - 1];
            for (int i = length - 1;i >= 1;i--){
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }

    public void rotate2(int[] nums,int k){
        int length = nums.length - 1;
        k = k % length;
        reverse(nums,0,length);
        reverse(nums,0,k - 1);
        reverse(nums,k,length);
    }

    private void reverse(int[] nums, int i, int length) {
        while (i < length){
            int temp = nums[i];
            nums[i] = nums[length];
            nums[length] = temp;
            i++;
            length--;
        }
    }

    public static void main(String[] args) {
        Title189 title189 = new Title189();
        title189.rotate2(new int[]{1,2,3,4,5,6,7},3);
        title189.rotate2(new int[]{-1},2);
    }
}

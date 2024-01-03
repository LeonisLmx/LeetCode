package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/16 3:48 下午
 */
public class Title2488 {

    public static int countSubarrays(int[] nums, int k) {
        int less = 1,big = 0, res = 1;
        boolean isFind = nums[0] == k;
        for (int i = 1;i < nums.length;i++){
            if (nums[i] == k){
                isFind = true;
                continue;
            }
            if (nums[i] < nums[i - 1]){
                if (isFind){
                    break;
                }
                less = 1;
                big = 0;
                isFind = false;
                continue;
            }
            if (isFind){
                big++;
            }else{
                less++;
            }
        }
        System.out.println(less);
        System.out.println(big);
        res += Math.min(less, big);
        if (big <= less){
            res += big;
        }else{
            res += (less + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14},6));
    }
}

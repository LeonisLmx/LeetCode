package Middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Urey
 * @Date: 2021/6/2
 */
public class Title523 {

    public boolean checkSubarraySum(int[] nums,int k){
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n;i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2;i <= n;i++){
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Title523 title523 = new Title523();
        //System.out.println(title523.checkSubarraySum(new int[]{23,2,4,6,7},6));
        System.out.println(title523.checkSubarraySum(new int[]{23,2,4,6,6},7));
        System.out.println(title523.checkSubarraySum(new int[]{1,0,1,0,1},4));
    }
}

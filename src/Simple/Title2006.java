package Simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * @date 2022/2/9 1:41 下午
 * [1,2,2,1]
 * 1
 * [1,3]
 * 3
 * [3,2,1,5,4]
 * 2
 */
public class Title2006 {

    public static int countKDifference(int[] nums,int k){
        int res = 0;
        for (int i = 0;i < nums.length - 1;i++){
            for (int j = i + 1;j < nums.length;j++){
                if (Math.abs(nums[i] - nums[j]) == k){
                    res++;
                }
            }
        }
        return res;
    }

    public static int countKDifference2(int[] nums,int k){
        int res = 0,n = nums.length;
        Map<Integer,Integer> cnt = new HashMap<>();
        for (int i = 0;i < n;i++){
            res += cnt.getOrDefault(nums[i] - k,0) + cnt.getOrDefault(nums[i] + k,0);
            cnt.put(nums[i],cnt.getOrDefault(nums[i],0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{1,2,2,1},1));
        System.out.println(countKDifference2(new int[]{1,2,2,1},1));
    }
}

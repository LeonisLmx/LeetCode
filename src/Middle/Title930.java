package Middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/7/8
 *
 */
public class Title930 {

    public int numSubarraysWithSum(int[] nums,int goal){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == goal){
                count++;
            }
            for (int j = i + 1;j < nums.length;j++){
                sum += nums[j];
                if (sum == goal){
                    count++;
                }else if (sum > goal){
                    break;
                }
            }
        }
        return count;
    }

    public int numSubarraysWithSums(int[] nums,int goal){
        // 统计所有1的下标
        List<Integer> oneList = new LinkedList<>();
        List<Integer> zeroList = new LinkedList<>();
        int count;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] == 1){
                oneList.add(i);
            }else{
                zeroList.add(i);
            }
        }
        if (oneList.size() < goal){
            return 0;
        }
        int[] dp = new int[nums.length];
        if (goal == 0){
            // 如果goal是0的话
            if (zeroList.size() == 0){
                return 0;
            }
            int start = zeroList.get(0);
            dp[start] = count = 1;
            for (int i  = start + 1;i < nums.length;i++){
                if (nums[i] == 0) {
                    dp[i] = dp[i - 1] + 1;
                }
                count += dp[i];
            }
        }else{
            // 如果goal有值,那么第一个成立的就是list的下标中为goal-1的值
            int index = 0,start = oneList.get(goal - 1);
            dp[start] = count = oneList.get(index) + 1;
            for (int i = start + 1;i < nums.length;i++){
                if (nums[i] == 0) {
                    dp[i] = dp[i - 1];
                }else {
                    index++;
                    dp[i] = oneList.get(index) - oneList.get(index - 1);
                }
                count += dp[i];
            }
        }
        return count;
    }

    public int numSubarrays(int[] nums,int goal){
        int sum = 0,ret = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(sum,map.getOrDefault(sum,0) + 1);
            sum += num;
            ret += map.getOrDefault(sum - goal,0);
        }
        return ret;
    }

    public static void main(String[] args) {
        Title930 title930 = new Title930();
        //System.out.println(title930.numSubarrays(new int[]{1,0,1,0,1},2));
//        System.out.println(title930.numSubarrays(new int[]{0,0,0,0,0,0,1,0,0,0},0));
        System.out.println(title930.numSubarrays(new int[]{0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0}, 3));
        System.out.println(title930.numSubarrays(new int[]{1,1,1,1,1,0,1,1,1,1},5));
    }
}

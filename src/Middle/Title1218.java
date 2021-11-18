package Middle;

import java.util.*;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/5 10:31 上午
 */
public class Title1218 {

    public int longestSubsequence(int[] arr,int difference){
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    public static void main(String[] args) {
        Title1218 title1218 = new Title1218();
        System.out.println(title1218.longestSubsequence(new int[]{1,2,3,4},1));
        System.out.println(title1218.longestSubsequence(new int[]{1,3,5,7},1));
        System.out.println(title1218.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1},-2));
    }
}

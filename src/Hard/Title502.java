package Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Auth or: Urey
 * @Date: 2021/9/8
 * dp[n] =
 */
public class Title502 {

    public static int findMaximizedCapital(int k,int w,int[] profits,int[] capital){
        // 记录哪些是已经做过的项目
        boolean[] arrs = new boolean[profits.length];
        Arrays.fill(arrs,false);
        int[] dp = new int[k];
        int i = 0,last = -1;
        while (i < k){
            for (int j = 0;j < profits.length;j++){
                // 说明是符合要求的
                if (capital[j] <= w && !arrs[j]){
                    if (profits[j] > dp[i]){
                        arrs[j] = true;
                        if (last >= 0){
                            arrs[last] = false;
                        }
                        last = j;
                        dp[i] = profits[j];
                    }
                }
            }
            last = -1;
            w += dp[i];
            i++;
        }
        return w;
    }

    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1}));
    }
}

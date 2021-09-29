package Middle;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Urey
 * @Date: 2021/9/10
 */
public class Title1894 {

    public static int chalkReplacer(int[] chalk,int k){
        int[] dp = new int[chalk.length];
        dp[0] = chalk[0];
        int start = 0,end = chalk.length - 1;
        for (int i = 1;i < chalk.length;i++){
            if (dp[i - 1] + chalk[i] < 0){
                // 说明超过int的最大值了
                end = i;
                break;
            }else {
                dp[i] = dp[i - 1] + chalk[i];
            }
        }
        int a = dp[chalk.length - 1] == 0?k:k % dp[chalk.length - 1];
        while (start < end){
            int middle = start + (end - start) / 2;
            if (dp[middle] <= a){
                start = middle + 1;
            }else{
                end = middle;
            }
        }
        return start;
    }

    public static void main(String[] args) throws InterruptedException {

    }
}

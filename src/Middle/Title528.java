package Middle;

import java.util.Random;

/**
 * @Author: Urey
 * @Date: 2021/8/30
 */
public class Title528 {

    int[] arr;
    // 取前缀和
    int[] dp;
    int sum;
    int length;

    public Title528(int[] w){
        arr = w;
        dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1;i < arr.length;i++){
            dp[i] = dp[i - 1] + arr[i];
        }
        sum = dp[arr.length - 1];
        length = arr.length;
    }

    public int pickIndex(){
        int a = new Random().nextInt(sum) + 1;
        System.out.println("随机数是:" + a);
        int start = 0,end = length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (dp[mid] < a){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Title528 title528 = new Title528(new int[]{1,3});
        System.out.println(title528.pickIndex());
        System.out.println(title528.pickIndex());
        System.out.println(title528.pickIndex());
        System.out.println(title528.pickIndex());
        System.out.println(title528.pickIndex());
    }
}

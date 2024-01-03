package Middle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author urey.liu
 * @description
 * 求出大于或等于N的最小回文素数。
 *
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 *
 * 例如，2，3，5，7，11 以及13 是素数。
 *
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 *
 * 例如，12321 是回文数。
 *
 *
 * @date 2023/4/11 1:53 下午
 * 分析：
 * 末尾是 0/2/4/5/6/8 的都pass,因为必然不是素数
 * 只剩下 1/3/7/9
 */
public class Title866 {

    public int primePalindrome(int n) {
        if (n <= 2){
            return 2;
        }
        while (n <= 11){
            if (prime(n)){
                return n;
            }
            n++;
        }
        Queue<String> queue = new ArrayDeque<>(Arrays.asList("11","33","77","99"));
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i < size;i++){
                String ans = queue.poll();
                int length = ans.length(),mod = length % 2,div = length / 2;
                if (mod == 0){
                    for (int j = 0;j <= 9;j++){
                        StringBuilder sb = new StringBuilder();
                        sb.append(ans, 0, div).append(j).append(ans,div,length);
                        if (Integer.parseInt(sb.toString()) >= n && prime(Integer.parseInt(sb.toString()))){
                            return Integer.parseInt(sb.toString());
                        }
                        queue.offer(sb.toString());
                    }
                }else{
                    StringBuilder sb = new StringBuilder();
                    sb.append(ans,0,div).append(ans,div,div + 1).append(ans,div,div + 1).append(ans,div + 1,length);
                    if (Integer.parseInt(sb.toString()) >= n && prime(Integer.parseInt(sb.toString()))){
                        return Integer.parseInt(sb.toString());
                    }
                    queue.offer(sb.toString());
                }
            }
        }
        return 0;
    }

    public boolean prime(int num){
        for (int i = 2;i <= Math.sqrt(num);i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Title866 title866 = new Title866();
        System.out.println(title866.primePalindrome(1));
        System.out.println(title866.primePalindrome(6));
        System.out.println(title866.primePalindrome(8));
        System.out.println(title866.primePalindrome(13));
        System.out.println(title866.primePalindrome(506));
    }
}

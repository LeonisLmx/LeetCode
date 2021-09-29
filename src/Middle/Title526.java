package Middle;

import offer.Title52;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: Urey
 * @Date: 2021/8/16
 */
public class Title526 {

    // 12 21
    // 123 213 321
    // 1234 2134 3214
    // 4231 4132
    // 1432 3412
    //1 [3]  2 [2]  3 [2]
    //1 [4]  2 [3]  3 [2]   4 [2]
    public int countArrangement(int n){
        Queue<String> queue = new LinkedBlockingDeque<>();
        queue.offer("1");
        for (int i = 2;i <= n;i++){
            // 所有的结果集
            int size = queue.size();
            for (int j = 0;j < size;j++){
                String str = queue.poll();
                queue.offer(str + i);
            }
            queue = getCount(queue,i);
            System.out.println(queue.toString());
        }
        return queue.size();
    }

    private Queue<String> getCount(Queue<String> strings, int length) {
        Queue<String> queue = new LinkedBlockingDeque<>(strings);
        for (int i = 0;i < length - 1;i++) {
            if (length % (i + 1) != 0 && (i + 1) % length != 0){
                continue;
            }
            // 和第一个数交换
            for (String string : strings) {
                char a = string.charAt(i);
                int num = Character.getNumericValue(a);
                if ((num % length == 0 || length % num == 0) &&
                        (length % (i + 1) == 0 || (i + 1) % length == 0)){
                    queue.offer(string.substring(0, i) + length + string.substring(i + 1, length - 1) + num);
                }
            }
        }
        return queue;
    }

    List<Integer>[] match;
    boolean[] vis;
    int num;

    public int countArrangement2(int n) {
        vis = new boolean[n + 1];
        match = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return num;
    }

    public void backtrack(int index, int n) {
        if (index == n + 1) {
            num++;
            return;
        }
        for (int x : match[index]) {
            if (!vis[x]) {
                vis[x] = true;
                backtrack(index + 1, n);
                vis[x] = false;
            }
        }
    }

    public static void main(String[] args) {
        Title526 title526 = new Title526();
        System.out.println(title526.countArrangement(6));
        title526.countArrangement2(6);
    }
}

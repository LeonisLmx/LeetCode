package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: Urey
 * @Date: 2021/6/25
 *dp[a][b][c][d] = Math.min(dp[a - 1][b][c][d],dp[a + 1][b][c][d],...)
 * 0202 [1202,9202,0102,0302,0292,0212,0201,0203]
 */
public class Title752 {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)){
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String deadend : deadends) {
            if ("0000".equals(deadend)){
                return -1;
            }
            set.add(deadend);
        }
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> strings = new HashSet<>();
        strings.add("0000");

        while (!queue.isEmpty()){
            ++step;
            int size = queue.size();
            for (int i = 0;i < size;i++){
                String str = queue.poll();
                for (String status : get(str)){
                    if (!strings.contains(status) && !set.contains(status)){
                        if (status.equals(target)){
                            return step;
                        }
                        queue.offer(status);
                        strings.add(status);
                    }
                }
            }
        }
        return -1;
    }

    public char getNext(char c){
        return c == '9'?'0':(char) (c + 1);
    }

    public char getPrev(char c){
        return c == '0'?'9':(char) (c - 1);
    }

    private List<String> get(String str) {
        List<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < 4; i++) {
            char temp = chars[i];
            chars[i] = getNext(temp);
            list.add(new String(chars));
            chars[i] = getPrev(temp);
            list.add(new String(chars));
            chars[i] = temp;
        }
        return list;
    }

    public static void main(String[] args) {
        Title752 title752 = new Title752();
        //System.out.println(title752.openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));
        char[] chars = new char[]{'1','2','3','4'};
        System.out.println(Arrays.toString(chars));
        System.out.println(new String(chars));
    }
}

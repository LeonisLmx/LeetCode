package Middle;

import java.util.*;

/**
 * @author urey.liu
 * @description
 * @date 2022/2/7 5:20 下午
 * ccbccacc
 */
public class Title1405 {

    public String longestDiverseString(int a,int b,int c){
        StringBuilder sb = new StringBuilder("");
        Pair[] pairs = new Pair[]{new Pair(a,'a'),new Pair(b,'b'),new Pair(c,'c')};
        while (true){
            boolean hasNext = false;
            Arrays.sort(pairs,(o1,o2) -> o2.num - o1.num);
            for (Pair pair : pairs) {
                if (pair.num <= 0){
                    break;
                }
                int m = sb.length();
                // 说明是重复的
                if (m >= 2 && sb.charAt(m - 1) == pair.ch && sb.charAt(m - 2) == pair.ch){
                    continue;
                }
                hasNext = true;
                sb.append(pair.ch);
                pair.num--;
                break;
            }
            if (!hasNext){
                break;
            }
        }
        return sb.toString();
    }

    class Pair{
        int num;
        char ch;

        public Pair(int num, char ch) {
            this.num = num;
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
//        System.out.println(longestDiverseString(1,1,7));
//        System.out.println(longestDiverseString(2,2,1));
//        System.out.println(longestDiverseString(7,1,0));
    }
}

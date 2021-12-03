package Simple;

import java.util.*;

/**
 * @author urey.liu
 * @description
 * @date 2021/12/2 10:38 上午
 */
public class Title506 {

    public static String[] findRelativeRanks(int[] score) {
        Map<Integer,Integer> sortMap = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        for (int i : score) {
            queue.offer(i);
        }
        int res = 1;
        while (!queue.isEmpty()){
            sortMap.put(queue.poll(),res);
            res++;
        }
        String[] strings = new String[score.length];
        for (int i = 0;i < score.length;i++) {
            int count = sortMap.get(score[i]);
            String s = "";
            switch (count){
                case 1:
                    s = "Gold Meda";
                    break;
                case 2:
                    s = "Silver Medal";
                    break;
                case 3:
                    s = "Bronze Medal";
                    break;
                default:
                    s = count + "";
                    break;
            }
            strings[i] = s;
        }
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10,3,8,9,4})));
    }
}

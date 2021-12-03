package Middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/24 10:42 上午
 * owoztneoer
 * fviefuro
 */
public class Title423 {

    String[] str = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};

    public String originalDigits(String s) {
        StringBuilder sb = new StringBuilder("");
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            map.merge(s.charAt(i),1,Integer::sum);
        }
        int[] res = new int[10];
        res[0] = map.getOrDefault('z',0);
        res[2] = map.getOrDefault('w',0);
        res[4] = map.getOrDefault('u',0);
        res[6] = map.getOrDefault('x',0);
        res[8] = map.getOrDefault('g',0);
        res[5] = map.getOrDefault('f',0) - res[4];
        res[3] = map.getOrDefault('h',0) - res[8];
        res[7] = map.getOrDefault('s',0) - res[6];
        res[1] = map.getOrDefault('o',0) - res[0] - res[2] - res[4];
        res[9] = (map.getOrDefault('n',0) - res[1] - res[7])/2;
        for (int i = 0;i < 10;i++){
            while (res[i] > 0){
                sb.append(i);
                res[i]--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Title423 title423 = new Title423();
        System.out.println(title423.originalDigits("owoztneoerzero"));
        System.out.println(title423.originalDigits("fviefuro"));
        System.out.println(title423.originalDigits("zeroonetwothreefourfivesixseveneightnine"));
    }
}

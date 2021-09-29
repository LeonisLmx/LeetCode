package Middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/7/7
 */
public class Title1711 {

    public int countPairs(int[] deliciousness) {
        int length = deliciousness.length,count = 0,mod = (int)Math.pow(10,9) + 7,max = 0;
        if (length == 1){
            return count;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < length;i++){
            max = Math.max(max,deliciousness[i]);
        }
        max = 2 * max;
        for (int i = 0;i < length;i++){
            for (int sum = 1;sum <= max;sum <<= 1){
                int pairs = map.getOrDefault(sum - deliciousness[i],0);
                count = (count + pairs) % mod;
            }
            map.put(deliciousness[i],map.getOrDefault(deliciousness[i],0) + 1);
        }
        return count % mod;
    }

    public static void main(String[] args) {
        Title1711 title1711 = new Title1711();
        //System.out.println(title1711.countPairs(new int[]{1,1,1,3,3,3,7}));
        System.out.println(title1711.countPairs(new int[]{149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234}));
    }
}

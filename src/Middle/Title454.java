package Middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2020/11/27
 */
public class Title454 {

    public int forSumCount(int[] A,int[] B,int[] C,int[] D){
        int num = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                map.put(i + j,map.getOrDefault(i + j,0) + 1);
            }
        }
        for (Integer o : C) {
            for (Integer o1 : D) {
                if (map.containsKey(-o -o1)){
                    num = map.get(-o-o1) + num;
                }
            }
        }
        return num;
    }
}

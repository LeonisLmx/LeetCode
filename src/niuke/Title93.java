package niuke;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @Author: Urey
 * @Date: 2021/8/20
 */
public class Title93 {

    public int[] LRU(int[][] operators,int k){
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int[] operator : operators) {
            queue.remove((Object) operator[1]);
            if (operator[0] == 1){
                map.remove(operator[1]);
                if (map.size() == k){
                    int key = queue.poll();
                    map.remove(key);
                }
                map.put(operator[1],operator[2]);
                queue.offer(operator[1]);
            }else{
                list.add(map.getOrDefault(operator[1],-1));
                if (map.containsKey(operator[1])){
                    queue.offer(operator[1]);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: Urey
 * @Date: 2021/6/28
 * 把车站看成一个整体
 */
public class Title815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target){
            return 0;
        }
        // 从某个车站出发的路线
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 可以从哪几个车站出发
        Queue<Integer> queue = new LinkedList<>();
        // 从某个车站出发的step
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (routes[i][j] == source){
                    queue.offer(i);
                    m.put(i,1);
                }
                Set<Integer> set = map.getOrDefault(routes[i][j],new HashSet<>());
                set.add(i);
                map.put(routes[i][j],set);
            }
        }
        while (!queue.isEmpty()){
            int index = queue.poll();
            int step = m.get(index);
            for (int station : routes[index]) {
                if (station == target){
                    return step;
                }
                Set<Integer> sets = map.getOrDefault(station,new HashSet<>());
                if (sets == null || sets.size() == 0){
                    continue;
                }
                for (Integer n : sets) {
                    // 每个车站都只能走一次的，所以如果存在的话那么以前的枚举没找到合适的，所以这次也必然不用走了
                    if (!m.containsKey(n)){
                        m.put(n,step + 1);
                        queue.offer(n);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Title815 title815 = new Title815();
        System.out.println(title815.numBusesToDestination(new int[][]{{1,2,7},{3,6,7}},1,6));
        System.out.println(title815.numBusesToDestination(new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}},15,12));
    }
}

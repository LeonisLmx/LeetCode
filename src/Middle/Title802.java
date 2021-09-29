package Middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: Urey
 * @Date: 2021/8/5
 */
public class Title802 {

    public List<Integer> eventualSafeNodes(int[][] graph){
        int length = graph.length;
        int[] color = new int[length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < length;i++){
            if (safe(graph,color,i)){
                list.add(i);
            }
        }
        return list;
    }

    private boolean safe(int[][] graph, int[] color, int i) {
        // 如果再次遍历到该节点，那么就看该节点是否在环上
        if (color[i] > 0){
            return color[i] == 2;
        }
        // 默认所有节点第一次都是1
        color[i] = 1;
        int[] arr = graph[i];
        for (int j : arr) {
            if (!safe(graph,color,j)){
                return false;
            }
        }
        color[i] = 2;
        return true;
    }


    public static void main(String[] args) {
        Title802 title802 = new Title802();
        //System.out.println(title802.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
        System.out.println(title802.eventualSafeNodes(new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}}));

        System.out.println("1a241243".hashCode() > "2a241243".hashCode());
        System.out.println("1b12345".hashCode() > "2b12345".hashCode());
    }
}

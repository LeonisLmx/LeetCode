package Hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: Urey
 * @Date: 2021/8/6
 */
public class Title847 {

    public int shortestPathLength(int[][] graph) {
        int length = graph.length;
        int[] dp = new int[length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 0;i < length;i++){
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            List<Integer> list = new ArrayList<>();
            List<String> pathList = new ArrayList<>();
            getLength(graph,i,0,queue,list,pathList);
            if (list.size() > 0) {
                dp[i] = list.stream().filter(n -> n > 0).min(Comparator.comparing(Function.identity())).orElse(0);
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }

    private void getLength(int[][] graph, int i,int length,Deque<Integer> deque,List<Integer> list,List<String> pathList) {
        if (new HashSet<>(deque).size() == graph.length){
            list.add(length);
            return;
        }
        for (int j : graph[i]) {
            String key = i + "_" + j;
            if (graph[i].length == 1 || !pathList.contains(key)){
                deque.offer(j);
                pathList.add(key);
                getLength(graph,j,length + 1,deque,list,pathList);
                deque.pollLast();
                pathList.remove(key);
            }
        }
    }


    public int shortestPathLength2(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if (mask == (1 << n) - 1) {
                ans = dist;
                break;
            }
            // 搜索相邻的节点
            for (int v : graph[u]) {
                // 将 mask 的第 v 位置为 1
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Title847 title847 = new Title847();
//        System.out.println(title847.shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}}));
//        System.out.println(title847.shortestPathLength(new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}}));
//        System.out.println(title847.shortestPathLength(new int[][]{{}}));
//        System.out.println(title847.shortestPathLength(new int[][]{{1},{0,2,4},{1,3},{2},{1,5},{4}}));
//        System.out.println(title847.shortestPathLength(new int[][]{{3},{2,3},{1},{0,1}}));
//        // 0 -> 2 -> 6 -> 2 -> ?
//        System.out.println(title847.shortestPathLength(new int[][]{{2,3},{7},{0,6},{0,4,7},{3,8},{7},{2},{5,3,1},{4}}));
        System.out.println(title847.shortestPathLength(new int[][]{{2,3,5,7},{2,3,7},{0,1},{0,1},{7},{0},{10},{9,10,0,1,4},{9},{7,8},{7,6}}));
    }
}

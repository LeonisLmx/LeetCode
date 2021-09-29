package Middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/8/25
 */
public class Title797 {

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        List<Integer> list = new LinkedList<>();
        list.add(0);
        bfs(0,graph,list);
        return lists;
    }

    private void bfs(int m, int[][] graph, List<Integer> list) {
        if (m == graph.length - 1){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0;i < graph[m].length;i++){
            int n = graph[m][i];
            list.add(n);
            bfs(n,graph,list);
            list.remove((Object) n);
        }
    }

    public static void main(String[] args) {
        Title797 title797 = new Title797();
        System.out.println(title797.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }
}

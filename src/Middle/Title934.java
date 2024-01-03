package Middle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author urey.liu
 * @description
 * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 *
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 *
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 *
 * 返回必须翻转的 0 的最小数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 *
 * 输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] 为 0 或 1
 * grid 中恰有两个岛
 *
 * @date 2022/10/25 10:43 上午
 */
public class Title934 {

    public int shortestBridge(int[][] grid) {
        int[][] ans = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        int step = 0;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1){
                    dfs(i,j,grid,queue);
                    while (!queue.isEmpty()){
                        int k = queue.size();
                        for (int u = 0;u < k;u++){
                            int[] res = queue.poll();
                            for (int v = 0;v < 4;v++){
                                int a = res[0] + ans[v][0];
                                int b = res[1] + ans[v][1];
                                if (a >= 0 && b >= 0 && a < n && b < n && grid[a][b] == 1){
                                    return step;
                                }else if (a >= 0 && b >= 0 && a < n && b < n && grid[a][b] == 0){
                                    grid[a][b] = -1;
                                    queue.offer(new int[]{a,b});
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return step;
    }

    private void dfs(int i, int j, int[][] grid, Queue<int[]> queue) {
        if (i < grid.length && j < grid.length && i >= 0 && j >= 0 && grid[i][j] == 1){
            grid[i][j] = -1;
            queue.offer(new int[]{i,j});
        }else{
            return;
        }
        dfs(i - 1,j,grid,queue);
        dfs(i,j - 1,grid, queue);
        dfs(i + 1,j,grid,queue);
        dfs(i, j + 1, grid, queue);
    }

    public static void main(String[] args) {
        Title934 title934 = new Title934();
        System.out.println(title934.shortestBridge(new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}}));
        System.out.println(title934.shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}}));
    }
}

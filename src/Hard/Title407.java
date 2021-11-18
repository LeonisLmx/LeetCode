package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/3 10:18 上午
 * [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * (x,y)  (x-1,y)(x + 1,y)(x,y - 1)(x,y + 1)
 */
public class Title407 {

    int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int trapRainWater(int[][] heightMap){
        int res = 0;
        if (heightMap.length <= 2 || heightMap[0].length <= 2){
            return 0;
        }
        boolean[][] visit = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0;i < heightMap.length;i++){
            for (int j = 0;j < heightMap[i].length;j++){
                if (i == 0 || i == heightMap.length - 1 || j == 0 || j == heightMap[i].length - 1){
                    queue.offer(new int[]{i,j,heightMap[i][j]});
                    visit[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0],y = arr[1],h = arr[2];
            for (int i = 0;i < 4;i++){
                int a = x + direction[i][0];
                int b = y + direction[i][1];
                if (a < 0 || a > heightMap.length - 1 || b < 0 || b > heightMap[0].length - 1){
                    continue;
                }
                if (visit[a][b]){
                    continue;
                }
                if (h > heightMap[a][b]){
                    res += h - heightMap[a][b];
                    heightMap[a][b] = h;
                }
                queue.offer(new int[]{a,b,heightMap[a][b]});
                visit[a][b] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Title407 title407 = new Title407();
        System.out.println(title407.trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
        System.out.println(title407.trapRainWater(new int[][]{{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}}));
    }
}

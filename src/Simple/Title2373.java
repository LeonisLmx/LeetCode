package Simple;

/**
 * @author urey.liu
 * @description
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 *
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
 *
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 *
 * 返回生成的矩阵。
 * @date 2023/3/1 1:37 下午
 */
public class Title2373 {

    public int[][] largestLocal(int[][] grid) {
        int length = grid[0].length;
        int[][] res = new int[length - 2][length - 2];
        for (int i = 0;i < length - 2;i++){
            for (int j = 0;j < length - 2;j++){
                res[i][j] = getMax(i, j, grid);
            }
        }
        return res;
    }

    private int getMax(int i, int j, int[][] grid) {
        int a = Math.max(Math.max(grid[i][j],grid[i + 1][j]),grid[i + 2][j]);
        int b = Math.max(Math.max(grid[i][j + 1],grid[i + 1][j + 1]),grid[i + 2][j + 1]);
        int c = Math.max(Math.max(grid[i][j + 2],grid[i + 1][j + 2]),grid[i + 2][j + 2]);
        return Math.max(Math.max(a, b),c);
    }
}

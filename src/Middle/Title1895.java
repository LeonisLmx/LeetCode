package Middle;

/**
 * @Author: Urey
 * @Date: 2021/8/24
 */
public class Title1895 {

    // 最小是1，最大是Math.min(m,n)
    public int largestMagicSquare(int[][] grid){
        int m = grid.length,n = grid[0].length;
        int min = Math.min(m,n);
        for (int i = min;i >= 2;i--){
            int a = 0,b = 0;
            while (a < n){
                if (check(a,b,grid,i)){
                    return i;
                }
                a++;
            }
            a = 0;
            while (b < m){
                if (check(a,b,grid,i)){
                    return i;
                }
                b++;
            }
        }
        // 最少是1
        return 1;
    }

    // a为横向坐标，b为纵向坐标
    private boolean check(int a, int b, int[][] grid, int index) {
        int last = 0;
        for (int i = b;i < grid[0].length - index;i++){
            int result = 0;
            for (int m = 0;m < index;m++){
                result += grid[i][m + a];
            }
            if (last == 0){
                last = result;
            }
            if (last != result){
                return false;
            }
        }
        for (int i = a;i < grid.length - index;i++){
            int result = 0;
            for (int m = 0;m < index;m++){
                result += grid[m + b][i];
            }
            if (last != result){
                return false;
            }
        }
        int result = 0;
        for (int i = 0;i < index;i++){
            a += i;
            b += i;
            result += grid[a][b];
        }
        if (last != result){
            return false;
        }
        a -= index;
        result = 0;
        for (int i = 0;i < index;i++){
            a += i;
            b -= i;
            result += grid[a][b];
        }
        if (last != result){
            return false;
        }
        return true;
    }
}

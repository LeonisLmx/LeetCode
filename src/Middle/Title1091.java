package Middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/5/10
 */
public class Title1091 {

    private static List<String> list;

    private static int temp;

    private static int result;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][1] != 0){
            return -1;
        }
        temp = grid[0].length;
        result = 1;
        list = new ArrayList<>();
        list.add("00");
        dfs(grid,0,0,result);
        return result == 1?-1:result;
    }

    private void dfs(int[][] grid, int index,int length, int result) {
        if (index == grid.length - 1){
            return;
        }
        if (length < temp - 1){
            if (grid[index][length++] == 0 && !list.contains(index + "" + length)){
                result++;
                list.add(index + "" + length);
                dfs(grid,index,length,result);
                length -= length;
                result--;
            }
            if (grid[index++][length++] == 0 && !list.contains(index + "" + length)){
                list.add(index + "" + length);
                dfs(grid,index,length,result);
                length--;
                index--;
                result--;
            }
        }
        if (grid[index++][length] == 0 && !list.contains(index + "" + length)){
            list.add(index + "" + length);
            dfs(grid,index,length,result);
            index--;
            result--;
        }
        index--;
        dfs(grid,index,length,result);
    }
}

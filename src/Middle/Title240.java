package Middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author urey.liu
 * @description
 * @date 2021/10/25 7:31 下午
 */
public class Title240 {

    public boolean searchMatrix(int[][] matrix, int target){
        loop:
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[i].length;j++){
                if (matrix[i][j] > target){
                    continue loop;
                }else if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    List<String> list;

    public boolean searchMatrix2(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Title240 title240 = new Title240();
        System.out.println(title240.searchMatrix2(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));
//        System.out.println(title240.searchMatrix2(new int[][]{{1,4},{2,5}},5));
//        System.out.println(title240.searchMatrix2(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},19));
//        System.out.println(title240.searchMatrix2(new int[][]{{2,5},{2,8},{7,9},{7,11},{9,11}},7));
    }
}

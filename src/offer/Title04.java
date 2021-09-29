package offer;

/**
 * @Author: Urey
 * @Date: 2020/12/9
 */
public class Title04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        // 从右上角开始找
        int m = 0,n = matrix[0].length - 1;
        // 获取最大的临界值
        int max1 = matrix.length - 1,max2 = matrix[0].length - 1;
        while (m <= max1 && n <= max2 && n >= 0){
            if (matrix[m][n] == target){
                return true;
            }else if (matrix[m][n] > target){
                n--;
            }else{
                m++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Title04 title04 = new Title04();
        int[][] matrix = new int[][]{{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int[][] matrix1 = new int[][]{{1,1}};
        int[][] matrix2 = new int[][]{{1}};
        System.out.println(title04.findNumberIn2DArray(matrix2,1));
    }
}

package Middle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/16 3:29 下午
 */
public class Title1605 {

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        for (int i = 0;i < rowSum.length;i++){
            for (int j = 0;j < colSum.length;j++){
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] = rowSum[i] - ans[i][j];
                colSum[j] = colSum[j] - ans[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8})));
    }
}

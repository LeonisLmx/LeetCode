package Simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author urey.liu
 * @description
 * @date 2022/2/15 11:12 上午
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        int[] ans = new int[m],res = new int[n];
        for (int i = 0;i < m;i++){
            ans[i] = Arrays.stream(matrix[i]).min().getAsInt();
            for (int j = 0;j < n;j++){
                res[j] = Math.max(res[j],matrix[i][j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (ans[i] == res[j]){
                    list.add(ans[i]);
                }
            }
        }
        return list;
    }
}

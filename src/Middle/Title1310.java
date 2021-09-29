package Middle;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/5/12
 */
public class Title1310 {

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0;i < ans.length;i++){
            int result = 0;
            for (int j = queries[i][0];j <= queries[i][1];j++){
                result = result ^ arr[j];
            }
            ans[i] = result;
        }
        return ans;
    }

    public static int[] xorQueries2(int[] arr,int[][] queries){
        int[] ans = new int[arr.length];
        int[] result = new int[queries.length];
        ans[0] = arr[0];
        for (int i = 1;i < arr.length;i++){
            ans[i] = ans[i - 1] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0){
                result[i] = ans[queries[i][1]];
            }else{
                result[i] = ans[queries[i][0] - 1] ^ ans[queries[i][1]];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(xorQueries(new int[]{1,3,4,8},new int[][]{{0,1},{1,2},{0,3},{3,3}})));
        System.out.println(Arrays.toString(xorQueries2(new int[]{1,3,4,8},new int[][]{{0,1},{1,2},{0,3},{3,3}})));
    }
}

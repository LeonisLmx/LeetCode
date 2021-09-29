package Middle;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/8/2
 */
public class Title743 {

    int[][] dp;
    // 维护距离的数组
    int[] distance;
    List<Integer> list;

    public int networkDelayTime(int[][] times,int n,int k){
        int length = times.length;
        distance = new int[n];
        dp = new int[n + 1][n + 1];
        for (int i = 1;i <= n;i++){
            if (i != k) {
                list.add(i);
            }
        }
        Arrays.fill(dp[k],-1);
        distance[k] = 0;
        dfs(times,k);
        return list.size() == 0?Arrays.stream(distance).max().getAsInt():-1;
    }

    private void dfs(int[][] times, int k) {
        if (list.size() == 0){
            return;
        }
        int min = -1,dis = -1;
        // 找距离最小的点再遍历
        for (int i = 0;i < times.length;i++){
            if (times[i][0] == k && list.contains(times[i][1])){
                if (dis == -1){
                    dis = times[i][2];
                    min = times[i][1];
                }else{
                    min = dis < times[i][2]?min:times[i][1];
                    dis = Math.min(times[i][2],dis);
                }
            }
        }
        k = min;
        dfs(times,k);
    }

    public static void main(String[] args) {
        Title743 title743 = new Title743();
        //System.out.println(title743.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2));
        //System.out.println(title743.networkDelayTime(new int[][]{{1,2,1},{2,1,3}},2,2));
        System.out.println(title743.networkDelayTime(new int[][]{{1,2,1},{2,3,2},{1,3,4}},3,1));
    }
}

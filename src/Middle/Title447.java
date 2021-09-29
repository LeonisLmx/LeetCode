package Middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/9/13
 */
public class Title447 {

    public int numberOfBoomeranges(int[][] points){
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Title447 title447 = new Title447();
        //System.out.println(title447.numberOfBoomeranges(new int[][]{{0,0},{1,0},{2,0}}));
        System.out.println(title447.numberOfBoomeranges(new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}}));
    }
}

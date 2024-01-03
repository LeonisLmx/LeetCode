package Middle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/30 4:41 下午
 */
public class Title1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            res = Math.max(res,points[i][0] - points[i - 1][0]);
        }
        return res;
    }
}

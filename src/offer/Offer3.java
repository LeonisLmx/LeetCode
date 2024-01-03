package offer;

import java.util.Arrays;
import java.util.Date;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/21 8:47 下午
 */
public class Offer3 {

    public int[] countBits(int n) {
        return null;
    }

    public static int cost(int n, int[] res){
        Arrays.sort(res);
        int sum = Arrays.stream(res).sum(),ans = 0;
        for (int i = res.length - 1;i >= 1;i--){
            ans += sum;
            sum -= res[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(cost(5, new int[]{5,1,3,2,1}));
    }
}

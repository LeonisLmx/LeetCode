package Middle;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/4/26
 */
public class Title1011 {

    // 回溯法
    public int shipWithinDays(int[] weights, int D) {
        int max = Arrays.stream(weights).max().getAsInt();
        int sum = Arrays.stream(weights).sum();
        int l = max,r = sum;
        while (l < r){
            int mid = (l + r) / 2;
            if (check(weights,mid,D)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int[] weights, int mid, int d) {
        int result = 0,day = 0;
        for (int i = 0;i < weights.length;i++){
            result += weights[i];
            if (result > mid){
                result = weights[i];
                day++;
            }
        }
        return day + 1 <= d;
    }

    public static void main(String[] args) {
        Title1011 title1011 = new Title1011();
        System.out.println(title1011.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
        System.out.println(title1011.shipWithinDays(new int[]{1,2,3,1,1},4));
    }
}

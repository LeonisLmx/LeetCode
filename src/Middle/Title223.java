package Middle;

/**
 * @Author: Urey
 * @Date: 2021/9/30
 */
public class Title223 {

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = ax2 - ax1,b = ay2 - ay1;
        int c = bx2 - bx1,d = by2 - by1;
        int s = a * b + c * d;
        // 说明没有交集
        if (ax1 > bx2 || ax2 < bx1 || ay1 > by2 || ay2 < by1){
            return s;
        }
        int x = Math.min(ax2,bx2) - Math.max(ax1,bx1);
        int y = Math.min(ay2,by2) - Math.max(ay1,by1);
        return s - x * y;
    }

    public static void main(String[] args) {
        System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
        System.out.println(computeArea(-2,-2,2,2,-2,-2,2,2));
    }
}

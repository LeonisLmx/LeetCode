package Simple;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/4 10:23 上午
 * 1 <= num <= 2^31 - 1
 */
public class Title367 {

    public static boolean isPerfectSquare(int num){
        double s = Math.sqrt(num);
        return s % ((int) s) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
    }
}

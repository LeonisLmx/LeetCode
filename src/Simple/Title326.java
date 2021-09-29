package Simple;

/**
 * @Author: Urey
 * @Date: 2021/9/23
 */
public class Title326 {

    public boolean isPowerOfThree(int n){
        while (n > 1){
            if (n % 3 > 0){
                return false;
            }
            n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.parseInt("1001",2));
    }
}

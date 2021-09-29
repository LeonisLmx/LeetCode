package offer;

/**
 * @Author: Urey
 * @Date: 2021/1/5
 */
public class Title15 {

    public int hammingWeight(int n) {
        int a = 0;
        while (n != 0){
            n = n & ( n - 1);
            a++;
        }
        return a;
    }

    public static void main(String[] args) {
        Title15 title15 = new Title15();
        System.out.println(title15.hammingWeight(0b1001));
        System.out.println(title15.hammingWeight(0b11111111111111111111111111111101));
    }
}

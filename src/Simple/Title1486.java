package Simple;

/**
 * @Author: Urey
 * @Date: 2021/5/7
 */
public class Title1486 {

    public int xorOperation(int n, int start) {
        int result = start;
        while (n - 1 > 0){
            start += 2;
            result = result ^ start;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        Title1486 title1486 = new Title1486();
        System.out.println(title1486.xorOperation(4,3));
    }
}

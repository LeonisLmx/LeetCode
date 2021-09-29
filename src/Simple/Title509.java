package Simple;

/**
 * @Author: Urey
 * @Date: 2021/1/4
 */
public class Title509 {

    public int fib(int n){
        if (n <= 1){
            return n;
        }
        if(n == 2){
            return 1;
        }
        int result = 2,first = 1,second = 2;
        while (result < n){
            int temp = second;
            second = first + second;
            first = temp;
            result++;
        }
        return first;
    }

    public static void main(String[] args) {
        Title509 title509 = new Title509();
        System.out.println(title509.fib(10));
    }
}

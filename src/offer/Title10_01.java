package offer;

import java.sql.PreparedStatement;

/**
 * @Author: Urey
 * @Date: 2020/12/22
 */
public class Title10_01 {

    public int fib(int n) {
        if (n == 0){
            return 1;
        }
        if (n <= 2){
            return n;
        }
        int first = 1,second = 2,result = 0;
        for (int i = 3;i <= n;i++){
            result = Math.floorMod(second +  first,1000000007);
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Title10_01 title10_01 = new Title10_01();
        System.out.println(title10_01.fib(2));
        System.out.println(title10_01.fib(7));
        System.out.println(title10_01.fib(10));
        System.out.println(title10_01.fib(48));
        System.out.println(title10_01.fib(95));
        System.out.println(Math.floorMod(1000000008,1000000007));
    }
}

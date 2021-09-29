package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/1/5
 * f(n) = f(n / 2) * f(n / 2)
 * f(n) = n * f((n-1) / 2) * f((n - 1) / 2)
 */
public class Title16 {

    Map<Long,Double> map = new HashMap<>();

    public double myPow(double x, int n) {
        if (x == 0 || x == 1){
            return x;
        }
        if (n == 0){
            return 1;
        }
        map.put(1L,x);
        long s = n;
        return n > 0?x(x,s):1/x(x,-s);
    }

    public double x(double x,long n){
        if (map.get(n) != null){
            return map.get(n);
        }
        if ((n & 1) == 0) {
            double result = x(x,n >> 1);
            map.put(n,result);
            return result * result;
        }else{
            double result = x(x,(n - 1) >> 1);
            map.put(n,result);
            return x * result * result;
        }
    }

    public static void main(String[] args) {
        Title16 title16 = new Title16();
        long s = Integer.MIN_VALUE;
        System.out.println(s);
        System.out.println(-s);
        System.out.println(title16.myPow(2,Integer.MIN_VALUE));
    }
}

package Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/8/13
 */
public class Title233 {

    static Map<Long,Integer> map = new HashMap<>();

    public static int countDigitOne(int n){
        int count = 0;
        for (long i = 1;i <= n;i++){
            int cur = 0;
            // 说明末尾数是1
            if (i % 10 == 1){
                cur++;
            }
            if (map.containsKey(i / 10)){
                cur += map.get(i / 10);
            }else if (i / 10 == 1){
                cur++;
            }
            count += cur;
            map.put(i,cur);
        }
        return count;
    }

    public static int countDigitOne1(int n){
        int ans = 0;
        for (int i = 1; i <= n; i *= 10) {
            // 表示有多少个集合在 [0,n]之间，因此就出现了多少个1
            ans += n / (i * 10) * i;
            int a = n % (i * 10);
            // 如果余数小于i,那么说明是0；
            // 如果余数大于i,小于2i的话，比如15，那就是15 - 10 + 1
            if  (i <= a && a < i * 2){
                ans += a - i + 1;
                // 如果余数大于2i的话，那么就是包含了所有的，即 i 个
            }else if (a >= i * 2){
                ans += i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(countDigitOne(13));
//        System.out.println(countDigitOne(21));
//        System.out.println(countDigitOne(1305));
        // 0 - 999999 / 1000000 - 1999999 / 2000000 - 2999999/ 3000000 - 3184191
        //System.out.println(countDigitOne(3184191));
        System.out.println(countDigitOne1(2));
        System.out.println(countDigitOne1(13));
        System.out.println(countDigitOne1(21));
        System.out.println(countDigitOne1(1305));
        // 0 - 999999 / 1000000 - 1999999 / 2000000 - 2999999/ 3000000 - 3184191
        System.out.println(countDigitOne1(3184191));
    }
}

package Middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * @date 2022/2/10 3:27 下午
 * 解析从1-n的所有数的质数分解
 */
public class Title1447 {

    Map<Integer,List<Integer>> map = new HashMap<>();

    public List<String> simplifiedFractions2(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1;i < n;i++){
            for (int j = i + 1;j <= n;j++){
                if (gcd(i,j)){
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }

    private boolean gcd(int a, int b) {
        int c = b % a;
        if (c == 0){
            return a == 1;
        }
        return gcd(Math.min(a,c),Math.max(a,c));
    }

    public List<String> simplifiedFractions(int n) {
        List<String> ant = new ArrayList<>();
        for (int i = 1;i <= n;i++){
            List<Integer> list = splitNum(i);
            map.put(i,list);
        }
        for (int i = 1;i < n;i++){
            for (int j = i + 1;j <= n;j++) {
                if (check(i, j)) {
                    ant.add(i + "/" + j);
                }
            }
        }
        return ant;
    }

    private boolean check(int res, int n) {
        List<Integer> a = map.get(res);
        List<Integer> b = map.get(n);
        for (Integer num : a) {
            if (b.contains(num)){
                return false;
            }
        }
        return true;
    }

    private List<Integer> splitNum(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 1){
            if (map.containsKey(n)){
                list.addAll(map.get(n));
                return list;
            }
            for (int i = 2;i <= Math.floor(n);i++){
                if (n % i == 0){
                    n = n / i;
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Title1447 title1447 = new Title1447();
        System.out.println(title1447.simplifiedFractions2(4));
    }
}

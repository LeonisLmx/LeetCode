package Middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * @date 2021/12/22 8:10 下午
 */
public class Title686 {

    public static int repeatedStringMatch(String a, String b) {
        int aLength = a.length(),res = 0,first = 0,end = 0;
        StringBuilder s = new StringBuilder();
        String head = "",tail = "";
        for (int i = 0;i < b.length();){
            if (a.equals(b.substring(i,Math.min(i + aLength,b.length())))){
                if (first == 0){
                    first = i;
                }
                res++;
                end = i + aLength;
                i += aLength;
            }else{
                s.append(b.charAt(i));
                i++;
            }
        }
        head = b.substring(0,first);
        tail = b.substring(end);
        if (s.toString().isEmpty()){
            return res;
        }
        if (!head.isEmpty()){
            int j = head.length() - 1,z = a.length() - 1;
            while (j >= 0){
                if (head.charAt(j) != a.charAt(z)){
                    return -1;
                }
                j--;
                z--;
            }
        }
        if (!tail.isEmpty()){
            int j = 0;
            while (j < tail.length()){
                if (tail.charAt(j) != a.charAt(j)){
                    return -1;
                }
                j++;
            }
        }
        if (a.contains(s)){
            return res + 1;
        }else if ((a + a).contains(s)){
            return res + 2;
        }else{
            return -1;
        }
    }

    public static int getAmount(int i){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(5,5);
        map.put(10,8);
        map.put(15,10);
        map.put(20,15);
        map.put(25,20);
        map.put(31,30);
        while (!map.containsKey(i) && i <= 31){
            i++;
        }
        return map.getOrDefault(i,0);
    }

    public static void main(String[] args) {
//        System.out.println(repeatedStringMatch("a","aa"));
//        System.out.println(repeatedStringMatch("a","a"));
//        System.out.println(repeatedStringMatch("abc","cabcabca"));
//        System.out.println(repeatedStringMatch("aaaaaaaaaaaaaaab","ba"));
        System.out.println(repeatedStringMatch("abcd","abcdb"));
//        System.out.println(getAmount(5));
//        System.out.println(getAmount(4));
//        System.out.println(getAmount(6));
    }
}

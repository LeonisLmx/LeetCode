package Middle;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/9/14
 */
public class Title524 {

    public String findLongestWord(String s, List<String> dictionary){
        int len = dictionary.size();
        String result = "";
        for (int i = 0;i < len;i++){
            String src = dictionary.get(i);
            if (result.length() <= src.length()){
                if (compare(s,src)){
                    if (result.length() < src.length()){
                        result = src;
                    }else{
                        result = result.compareTo(src) > 0 ? src:result;
                    }
                }
            }
        }
        return result;
    }

    private boolean compare(String s, String src) {
        int a = 0,b = 0;
        while (a < s.length() && b < src.length()){
            if (s.charAt(a) == src.charAt(b)){
                b++;
            }
            a++;
        }
        return b == src.length();
    }

    public static void main(String[] args) {
        Title524 title524 = new Title524();
        System.out.println(title524.findLongestWord("abpcplea", Arrays.asList("a","b","c")));
        System.out.println(title524.findLongestWord("abce", Arrays.asList("abe","abc")));
        System.out.println(title524.findLongestWord("bab", Arrays.asList("ba","ab","a","b")));
    }
}

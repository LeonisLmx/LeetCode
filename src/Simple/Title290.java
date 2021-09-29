package Simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2020/12/16
 */
public class Title290 {

    public boolean wordPattern(String pattern, String s) {
        char[] c = pattern.toCharArray();
        String[] str = s.split(" ");
        if (c.length !=  str.length){
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> revertMap = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            map.putIfAbsent(c[i],str[i]);
            revertMap.putIfAbsent(str[i],c[i]);
            if (!str[i].equals(map.get(c[i])) || c[i] != revertMap.get(str[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Title290 title290 = new Title290();
        System.out.println(title290.wordPattern("abba","dog cat cat dog"));
        System.out.println(title290.wordPattern("abba","dog cat cat fish"));
        System.out.println(title290.wordPattern("abba","dog dog dog dog"));
    }
}

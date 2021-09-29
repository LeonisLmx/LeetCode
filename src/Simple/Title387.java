package Simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Urey
 * @Date: 2020/12/23
 */
public class Title387 {

    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), i);
            }else{
                map.put(s.charAt(i),-1);
            }
        }
        for (int i = 0;i < s.length();i++){
            if (map.get(s.charAt(i)) >= 0){
                return map.get(s.charAt(i));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Title387 title387 = new Title387();
        System.out.println(title387.firstUniqChar("leetcode"));
        System.out.println(title387.firstUniqChar("loveleetcode"));
    }
}

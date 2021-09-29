package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Urey
 * @Date: 2020/12/14
 */
public class Title49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0;i  < str.length();i++){
                counts[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0){
                    sb.append(counts[i]).append((char)('a' + i));
                }
            }
            String key = sb.toString();
            List<String>  list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Title49 title49 = new Title49();
        System.out.println(title49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toString());
    }
}

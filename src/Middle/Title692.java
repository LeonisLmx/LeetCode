package Middle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Urey
 * @Date: 2021/5/20
 */
public class Title692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> countMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        int index = 1;
        for (int i = 0; i < words.length; i++) {
            countMap.merge(words[i],1, Integer::sum);
            index++;
        }
        Map<String,Integer> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (countMap.get(o1).compareTo(countMap.get(o2)) > 0){
                    return -1;
                }else if (countMap.get(o1).compareTo(countMap.get(o2)) == 0){
                    return o1.compareTo(o2);
                }else{
                    return 1;
                }
            }
        });
        treeMap.putAll(countMap);
        treeMap.forEach((key,value) -> {
            if (list.size() < k) {
                list.add(key);
            }
        });
        return list;
    }

    public static void main(String[] args) {
        Title692 title692 = new Title692();
        System.out.println(title692.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
    }
}

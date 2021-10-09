package Middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/10/8
 */
public class Title187 {

    public List<String> findRepeatedDnaSequences(String s){
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int len = s.length();
        for (int i = 0;i <= len - 10;i++){
            String str = s.substring(i,i + 10);
            map.merge(str,1,Integer::sum);
            if (map.get(str) == 2){
                list.add(str);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Title187 title187 = new Title187();
        System.out.println(title187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}

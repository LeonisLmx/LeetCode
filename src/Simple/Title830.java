package Simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/1/5
 */
public class Title830 {

    public List<List<Integer>> largeGroupPositions(String s) {
        char last = '0';
        int count = 0,length = s.length();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0;i < length;i++){
            if (last != s.charAt(i)){
                if (count >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i - count);
                    list.add(i - 1);
                    lists.add(list);
                }
                last = s.charAt(i);
                count = 1;
            }else{
                count++;
            }
        }
        if (count >= 3){
            List<Integer> list = new ArrayList<>();
            list.add(length - count);
            list.add(length - 1);
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        Title830 title830 = new Title830();
        System.out.println(title830.largeGroupPositions("abbxxxxzzy"));
        System.out.println(title830.largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(title830.largeGroupPositions("aaa"));
    }
}

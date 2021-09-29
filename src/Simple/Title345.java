package Simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/8/19
 */
public class Title345 {

    public static String reverseVowels(String s){
        List<String> list = Arrays.asList("A","E","I","O","U","a","e","i","o","u");
        int start = 0,end = s.length() - 1;
        StringBuilder startStr = new StringBuilder("");
        StringBuilder endStr = new StringBuilder("");
        while (start <= end){
            String a = Character.toString(s.charAt(start));
            String b = Character.toString(s.charAt(end));
            if (start == end){
                startStr.append(a);
                break;
            }
            if (!list.contains(a)){
                startStr.append(a);
                start++;
            }
            if (!list.contains(b)){
                endStr.append(b);
                end--;
            }
            if (list.contains(a) && list.contains(b)){
                startStr.append(b);
                endStr.append(a);
                start++;
                end--;
            }
        }
        return startStr.append(endStr.reverse()).toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels(" "));
        System.out.println(reverseVowels("a."));
    }
}

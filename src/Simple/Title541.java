package Simple;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/8/23
 */
public class Title541 {

    public String reverseStr(String s,int k){
        int start = 0;
        char[] chars = s.toCharArray();
        while (start < chars.length - 1){
            int min = Math.min(start + k - 1,chars.length - 1);
            reverse(chars,start,min);
            start = start + 2 * k;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int min) {
        while (start < min){
            char temp = chars[start];
            chars[start] = chars[min];
            chars[min] = temp;
            start++;
            min--;
        }
    }

    public static void main(String[] args) {
        Title541 title541 = new Title541();
        System.out.println(title541.reverseStr("abcdefg",2));
    }
}

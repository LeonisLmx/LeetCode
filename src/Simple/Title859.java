package Simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/23 1:41 下午
 */
public class Title859 {

    public boolean buddyStrings(String s,String goal){
        int len = s.length();
        char[] a = s.toCharArray(),b = goal.toCharArray();
        int index = -1,count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < len;i++){
            map.merge(a[i],1,Integer::sum);
            count = Math.max(count,map.get(a[i]));
            if (a[i] != b[i]){
                if (index == -1) {
                    index = i;
                }else{
                    char temp = a[i];
                    a[i] = a[index];
                    a[index] = temp;
                    return Arrays.toString(a).equals(Arrays.toString(b));
                }
            }
        }
        return Arrays.toString(a).equals(Arrays.toString(b)) && count >= 2;
    }

    public static void main(String[] args) {
        Title859 title859 = new Title859();
        System.out.println(title859.buddyStrings("ab","ba"));
    }
}

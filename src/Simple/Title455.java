package Simple;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2020/12/25
 */
public class Title455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0,i = 0,j = 0;
        while (i < g.length && j < s.length){
            if (g[i] <= s[j]){
                result++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Title455 title455 = new Title455();
        System.out.println(title455.findContentChildren(new int[]{1,2,3},new int[]{1,1}));
        System.out.println(title455.findContentChildren(new int[]{10,9,8,7},new int[]{5,6,7,8}));
    }
}

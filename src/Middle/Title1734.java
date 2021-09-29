package Middle;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/5/11
 */
public class Title1734 {

    public int[] decode(int[] encoded) {
        int length = encoded.length + 1;
        int[] ans = new int[length];
        int res1 = 0;
        for (int i = 1;i < length - 1;){
            res1 = res1 ^ encoded[i];
            i += 2;
        }
        int res2 = 0;
        for (int i = 1;i <= length;i++){
            res2 = res2 ^ i;
        }
        ans[0] = res1 ^ res2;
        for (int i = 0;i < length - 1;i++){
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Title1734 title1734 = new Title1734();
        System.out.println(Arrays.toString(Arrays.stream(title1734.decode(new int[]{3, 1})).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(title1734.decode(new int[]{6,5,4,6})).toArray()));
    }
}

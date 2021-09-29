package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Urey
 * @Date: 2021/6/22
 */
public class TitleOffer38 {

    public String[] permutation(String s) {
        if (s == null || s.length() == 0){
            return new String[]{};
        }
        String[] str = s.split("");
        boolean[] v = new boolean[str.length];
        Set<String> set = new HashSet<>();
        revert(str,0,s.length(),new StringBuilder(),set,v);
        return set.toArray(new String[]{});
    }

    private void revert(String[] str, int i, int length, StringBuilder stringBuilder,Set<String> set,boolean[] v) {
        if (i == length){
            set.add(stringBuilder.toString());
            return;
        }
        for (int j = 0;j < length;j++){
            if (!v[j]) {
                stringBuilder.append(str[j]);
                v[j] = true;
                revert(str, i + 1, length, stringBuilder, set,v);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                v[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        TitleOffer38 title38 = new TitleOffer38();
        System.out.println(Arrays.toString(title38.permutation("abc")));
    }
}

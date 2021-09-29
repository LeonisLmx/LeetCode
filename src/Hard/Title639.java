package Hard;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/9/27
 */
public class Title639 {

    // 1    1
    // 11   2
    // 111  3
    // 1111 7
    // 11111
    public int numDecodings(String s){
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = s.charAt(0) == '*'?9:1;
        for (int i = 1;i <= n;i++){
            if (s.charAt(i - 1) != '0'){
                if (s.charAt(i - 1) == '*'){
                    f[i] = f[i - 1] + 9;
                }else {
                    f[i] += f[i - 1];
                }
            }
            if (i > 1 && s.charAt(i - 2) != '0'){
                if (s.charAt(i - 2) == '*'){
                    if (s.charAt(i - 1) == '*'){
                        f[i] = f[i - 2] + 18;
                    }else {
                        f[i] = f[i - 2] + 2;
                    }
                }else{
                    if (s.charAt(i - 1) == '*'){
                        if (s.charAt(i - 2) == '1'){
                            f[i] = f[i - 2] + 9;
                        }else if (s.charAt(i - 2) == '2'){
                            f[i] = f[i - 2] + 6;
                        }
                    }else{
                        if((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26){
                            f[i] += f[i - 2];
                        }
                    }
                }
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        Title639 title639 = new Title639();
        System.out.println(title639.numDecodings("111"));
        System.out.println(title639.numDecodings("1111"));
    }
}

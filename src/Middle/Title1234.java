package Middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 *
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 *
 *  
 *
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 *
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 *
 * 请返回待替换子串的最小可能长度。
 *
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * @date 2023/2/13 1:50 下午
 */
public class Title1234 {

    public int balancedString(String s) {
        int[] ints = new int[26];
        for (int i = 0;i < s.length();i++){
            ints[s.charAt(i) - 'A']++;
        }
        int count = s.length() / 4;
        if (check(ints, count)){
            return 0;
        }
        int res = 0;
        for (int left = 0,right = 0;left < s.length();left++){
            // 向右边瞬移的时候需要维护字母次数
            while (right < s.length() && !check(ints, count)){
                ints[s.charAt(right) - 'A']--;
                right++;
            }
            if (!check(ints, count)){
                break;
            }
            res = Math.min(res, right - left);
            ints[s.charAt(left) - 'A']++;
        }
        return res;
    }

    public int balancedString2(String s){
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[idx(c)]++;
        }

        int partial = s.length() / 4;
        int res = s.length();

        if (check(cnt, partial)) {
            return 0;
        }
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !check(cnt, partial)) {
                cnt[idx(s.charAt(r))]--;
                r++;
            }
            if (!check(cnt, partial)) {
                break;
            }
            res = Math.min(res, r - l);
            cnt[idx(s.charAt(l))]++;
        }
        return res;
    }

    public int idx(char c) {
        return c - 'A';
    }

    public boolean check(int[] cnt, int partial) {
        if (cnt[idx('Q')] > partial || cnt[idx('W')] > partial || cnt[idx('E')] > partial || cnt[idx('R')] > partial) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(balancedString("QQWE"));
//        System.out.println(balancedString("QQQQ"));
//        System.out.println(balancedString("QQQQQQQQ"));
//        System.out.println(balancedString("QWQWQWQW"));
//        System.out.println(balancedString("WQWRQQQW"));
//        System.out.println(balancedString("WWQQRRRRQRQQ"));
//        System.out.println(balancedString("WWEQERQWQWWRWWERQWEQ"));
    }
}

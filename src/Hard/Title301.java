package Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author urey.liu
 * @description
 * @date 2021/10/27 10:37 上午
 * ()())()
 * (a)())()
 *
 * 第一个必须是左括号或者是字母
 * 最后一个必须是右括号或者是字母
 */
public class Title301 {

    List<String> list = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int length = s.length(),left = 0,right = 0;
        // 确定删除几个字符能变成有效括号
        for (int i = 0;i < length;i++){
            if (s.charAt(i) == '('){
                left++;
            }else if (s.charAt(i) == ')'){
                if (left == 0){
                    right++;
                }else{
                    left--;
                }
            }
        }
        helper(s,0,left,right);
        return list;
    }

    private void helper(String str, int start,int left, int right) {
        if (left == 0 && right == 0){
            if (isValiad(str)){
                list.add(str);
            }
            return;
        }

        for (int i = start; i < str.length();i++){
            if (i != start && str.charAt(i) == str.charAt(i - 1)){
                continue;
            }
            if (left + right > str.length() - i){
                return;
            }
            if (left > 0 && str.charAt(i) == '('){
                helper(str.substring(0,i) + str.substring(i + 1),i,left - 1,right);
            }
            if (right > 0 && str.charAt(i) == ')'){
                helper(str.substring(0,i) + str.substring(i + 1),i,left,right - 1);
            }
        }
    }

    private boolean isValiad(String str) {
        int ret = 0;
        for (int i = 0;i < str.length();i++){
            if (str.charAt(i) == '('){
                ret++;
            }else if (str.charAt(i) == ')'){
                ret--;
                if (ret < 0){
                    return false;
                }
            }
        }
        return ret == 0;
    }

    public static void main(String[] args) {
        Title301 title301 = new Title301();
        System.out.println(title301.removeInvalidParentheses("(r(()()("));
    }
}

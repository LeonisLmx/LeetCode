package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author urey.liu
 * @description
 * todo
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串
 *
 *  (((())))) -> (((1))) -> ((2 * 1)) -> 2 * 2 * 1
 * @date 2022/10/9 7:37 下午
 */
public class Title856 {

    public int scoreOfParentheses(String s) {
        List<String> list = new ArrayList<>(Arrays.asList(s.split("")));
        List<String> strings = new ArrayList<>();
        for (int i = 0;i < list.size();i++){
            String str = list.get(i);
            if (list.get(i).equals(")")){
                if (list.get(i - 1).equals("(")){
                    str = "1";
                }else{
                    str = 2 * Integer.parseInt(list.get(i - 1)) + "";
                }
                if (i > 2){
                    if (list.get(i - 2).equals("(") || list.get(i - 2).equals(")")){
                        list.add(str);
                    }else{
                        list.add(Integer.parseInt(list.get(i - 2)) + Integer.parseInt(str) + "");
                    }
                }
            }
            list.add(str);
        }
        return -1;
    }
}

package Hard;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Urey
 * @Date: 2021/7/5
 */
public class Title726 {

    Map<String,Integer> map = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });
    StringBuilder sb = new StringBuilder("");

    public String countOfAtoms(String formula){
        revert(formula,0,formula.length(),0,1);
        StringBuilder out = new StringBuilder("");
        map.forEach((k,v) -> {
            out.append(k);
            if (v > 1){
                out.append(v);
            }
        });
        return out.toString();
    }

    /**
     * 递归
     * @param formula 被检索的字符串
     * @param left 左指针
     * @param right 右指针
     * @param last 第一个出现数字的指针
     * @param multiple 当前字符串的倍数，默认是1
     */
    private void revert(String formula, int left, int right,int last,int multiple) {
        for (int i = left;i < right;i++){
            if (formula.charAt(i) == '('){
                explain(formula,i,last,multiple,false);
                last = 0;
                int rightIndex = findNext(formula,i);
                int mutile = findMultiple(formula,rightIndex);
                revert(formula,i + 1,rightIndex,0,mutile * multiple);
                // left 赋值为找到的数字
                i = rightIndex;
                if (mutile > 1) {
                    i = i + (mutile + "").length();
                }
            }else if (Character.isUpperCase(formula.charAt(i))){
                // 大写字母¡
                explain(formula,i,last,multiple,true);
                last = 0;
            }else if (Character.isLowerCase(formula.charAt(i))){
                // 小写字母
                sb.append(formula.charAt(i));
            }else{
                // 数字的情况下，记录指针
                last = last == 0?i:last;
            }
        }
        if (sb.length() > 0){
            map.merge(sb.toString(),last == 0?multiple:Integer.parseInt(formula.substring(last,right)) * multiple,Integer::sum);
            sb = new StringBuilder("");
            last = 0;
        }
    }

    public void explain(String formula,int i,int last,int multiple,boolean flag){
        if (sb.length() > 0){
            map.merge(sb.toString(),last == 0?multiple:Integer.parseInt(formula.substring(last,i)) * multiple,Integer::sum);
            sb = new StringBuilder("");
        }
        if (flag) {
            sb.append(formula.charAt(i));
        }
    }

    public Integer findNext(String formula,int left){
        int index = 1;
        while (true){
            left++;
            if (formula.charAt(left) == '('){
                index++;
            }
            if (formula.charAt(left) == ')'){
                index--;
            }
            if (index == 0){
                return left;
            }
        }
    }

    public Integer findMultiple(String formula,int left){
        left++;
        if (formula.length() == left || !Character.isDigit(formula.charAt(left))){
            return 1;
        }
        int start = left;
        int end = start;
        while (left < formula.length() - 1){
            left++;
            if (formula.charAt(left) - '0' >= 0 && formula.charAt(left) - '0' <= 9) {
                end = left;
            }else{
                break;
            }
        }
        return Integer.parseInt(formula.substring(start,end + 1));
    }

    public static void main(String[] args) {
        Title726 title726 = new Title726();
        //System.out.println(title726.countOfAtoms("H2O"));
        //System.out.println(title726.countOfAtoms("Mg(OH)2"));
        //System.out.println(title726.countOfAtoms("K4(ON(SO3)2)2"));
        //System.out.println(title726.countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
        //System.out.println(title726.countOfAtoms("(H)"));
        System.out.println(title726.countOfAtoms("Mg(H2O)N"));
    }
}

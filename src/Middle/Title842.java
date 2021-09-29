package Middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2020/12/8
 */
public class Title842 {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backtrack(S.toCharArray(),0,list);
        return list;
    }

    private boolean backtrack(char[] digit,int index,List<Integer> res) {
        if (index == digit.length && res.size() >= 3) {
            return true;
        }
        for (int i = index; i < digit.length; i++) {
            //两位以上的数字不能以0开头
            if (digit[index] == '0' && i > index) {
                break;
            }
            //截取字符串转化为数字
            long num = subDigit(digit, index, i + 1);
            //如果截取的数字大于int的最大值，则终止截取
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = res.size();
            //如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
            if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                //把数字num添加到集合res中
                res.add((int) num);
                //如果找到了就直接返回
                if (backtrack(digit, i + 1, res)) {
                    return true;
                }
                //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    //相当于截取字符串S中的子串然后转换为十进制数字
    private long subDigit(char[] digit, int start, int end) {
        long res = 0;
        for (int i = start; i <= end; i++) {
            res = res * 10 + digit[i] - '0';
        }
        return res;
    }

    private boolean dfs(char[] arrs,int start,int step,List<Integer> list){
        if (start == arrs.length && list.size() >= 3) {
            return true;
        }
        for (int i = start; i < arrs.length - step; i++) {
            if (arrs[i] == '0' && i > start){
                break;
            }
            long num = subDigit(arrs,i,i + step);
            if (num > Integer.MAX_VALUE){
                break;
            }
            int size = list.size();
            if (size <= 2){
                list.add((int)num);
            }else{
                if (num > list.get(size - 1) + list.get(size - 2)){
                    break;
                }
                if (num == list.get(size - 1) + list.get(size - 2)){
                    list.add((int)num);
                }else{
                    dfs(arrs,i,step++,list);
                    list.remove(size - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Title842 title842 = new Title842();
        //System.out.println(title842.splitIntoFibonacci("11235813").toString());
        System.out.println(title842.splitIntoFibonacci("123456579").toString());
    }
}

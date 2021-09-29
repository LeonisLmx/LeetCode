package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/1/15
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int[] ints = new int[(int)Math.pow(10,n) - 1];
        for (int i = 1;i <= ints.length;i++){
            ints[i - 1] = i;
        }
        return ints;
    }

    List<String> initList;
    public void printNumbers2(int n) {
        initList = new ArrayList<>();
        for (int i = 0;i <= 9;i++){
            initList.add(i + "");
        }
        List<String> list = new ArrayList<>();
        for (int i = 1;i <= n;i++){
            list = print(list);
            System.out.println(list.toString());
        }
    }

    private List<String> print(List<String> list) {
        if (list.size() == 0){
            for (int j = 1;j <= 9;j++){
                list.add(j + "");
            }
            return list;
        }else{
            List<String> results = new ArrayList<>();
            for (String s : list) {
                for (String s1 : initList) {
                    results.add(s + s1);
                }
            }
            return results;
        }
    }

    public static void main(String[] args) {
        Offer17 offer17 = new Offer17();
        offer17.printNumbers2(8);
    }
}

package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/9/16
 */
public class Random {

    public List<Integer> splitNum(int n){
        List<Integer> list = new ArrayList<>();
        List<Integer> lists = new ArrayList<>();
        for (int i = 2;i <= n;i++){
            if (judge(i)){
                lists.add(i);
            }
        }
        loop:
        while (n != 1){
            for (int i = 0;i < lists.size();i++){
                if (n % lists.get(i) == 0){
                    n = n / lists.get(i);
                    list.add(lists.get(i));
                    continue loop;
                }
            }
        }
        return list;
    }

    public boolean judge(int num){
        for (int i = 2;i < num;i++){
            if (num % i == 0 && num / i > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.splitNum(8));
        System.out.println(random.splitNum(13));
        System.out.println(random.splitNum(15));
    }
}

package Middle;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Urey
 * @Date: 2021/7/29
 */
public class Title1104 {

    List<Integer> list = new LinkedList<>();

    public List<Integer> pathInZigZagTree(int label){
        int level = 0;
        // 定位到数字在第几层
        if (label == 1){
            return Collections.singletonList(1);
        }
        for (int i = 1; i < 32; i++){
            if (label < Math.pow(2,i)){
                level = i;
                break;
            }
        }
        list.add(0,label);
        // 在level行的第多少个index
        int index = 0;
        int max = (int)Math.pow(2,level) - 1;
        int min = (int)Math.pow(2,level - 1);
        if (level % 2 == 0) {
            while (max >= label) {
                max--;
                index++;
            }
        }else{
            while (min <= label){
                min++;
                index++;
            }
        }
        dfs(level - 1,index);
        return list;
    }

    private void dfs(int level,int index) {
        if (level == 0){
            return;
        }
        if (index % 2 == 0){
            index = index / 2;
        }else{
            index = index / 2 + 1;
        }
        if (level % 2 == 0){
            int max = (int)Math.pow(2,level) - 1;
            list.add(0,max - index + 1);
        }else{
            int min = (int)Math.pow(2,level - 1);
            list.add(0,min + index - 1);
        }
        dfs(level - 1,index);
    }

    public static void main(String[] args) {
        Title1104 title1104 = new Title1104();
        //System.out.println(title1104.pathInZigZagTree(14));
        System.out.println(title1104.pathInZigZagTree(26));
    }
}

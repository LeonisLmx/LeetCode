package Simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/1/14
 */
public class Title1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        int lastNum = 0;
        List<Boolean> list = new ArrayList<>();
        for (int j : A) {
            lastNum = lastNum << 1;
            if (j == 1){
                lastNum++;
            }
            lastNum = lastNum % 10;
            if (lastNum == 0 || lastNum == 5){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Title1018 title1018 = new Title1018();
        System.out.println(title1018.prefixesDivBy5(new int[]{0,1,1}));
        System.out.println(title1018.prefixesDivBy5(new int[]{1,1,1}));
        System.out.println(title1018.prefixesDivBy5(new int[]{0,1,1,1,1,1}));
        System.out.println(title1018.prefixesDivBy5(new int[]{1,1,1,0,1}));
        System.out.println(title1018.prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}));
    }
}

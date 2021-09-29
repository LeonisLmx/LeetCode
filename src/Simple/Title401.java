package Simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/6/21
 * 0000
 * 000000
 */
public class Title401 {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        for (int i = 0;i < 12;i++){
            for (int j = 0;j < 60;j++){
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
                    list.add(i + ":" + (j < 10?"0" + j:j));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("1111",2));
        System.out.println(Integer.valueOf("011111",2));
    }
}

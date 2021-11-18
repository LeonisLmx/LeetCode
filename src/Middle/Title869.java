package Middle;

import java.util.*;

/**
 * @author urey.liu
 * @description
 * @date 2021/10/28 10:43 上午
 * 1 1 2 4 8
 * 2 16 32 64
 * 3 128 256 512
 * 4 1024 2048 4096 8192
 */
public class Title869 {

    public boolean recordedPowerOf2(int n){
        String str = n + "";
        int len = str.length();
        String[] arr = str.split("");
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < 31;i++){
            Integer num = (int)Math.pow(2,i);
            if ((num + "").length() > len){
                break;
            }else if ((num + "").length() == len){
                list.add(num);
            }
        }
        loop:
        for (Integer integer : list) {
            String[] strings = (integer + "").split("");
            Arrays.sort(strings);
            for (int i = 0;i < len;i++){
                if (!strings[i].equals(arr[i])){
                    continue loop;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(8 & 7);
        System.out.println(7 & 6);
        System.out.println(new Random().nextInt(60));
    }
}

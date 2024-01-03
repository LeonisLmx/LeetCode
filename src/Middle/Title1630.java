package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/16 4:52 下午
 * 4，6，5，9，3，7
 */
public class Title1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        int length = l.length;
        loop:
        for (int i = 0;i < length;i++){
            int left = l[i],right = r[i];
            int[] arr = Arrays.copyOfRange(nums, left, right + 1);
            Arrays.sort(arr);
            int index = 0,res = left < right?arr[index + 1] - arr[index]:0;
            while (index < right - left){
                if(res != arr[index + 1] - arr[index]){
                    list.add(false);
                    continue loop;
                }
                index++;
            }
            list.add(true);
        }
        return list;
    }

    public static void main(String[] args) {
        Title1630 title1630 = new Title1630();
//        System.out.println(title1630.checkArithmeticSubarrays(new int[]{4,6,5,9,3,7},new int[]{0,0,2},new int[]{2,3,5}));
        System.out.println(1 ^ 1);
        System.out.println(3 ^ 1);
    }
}

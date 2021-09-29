package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: Urey
 * @Date: 2021/7/15
 */
public class Title1846 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        arr[1] = 0;
        for (int i = 1;i < len;i++){
            if (arr[i] - arr[i - 1] > 1){
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[len - 1];
    }

    public static void main(String[] args) {
        Title1846 title1846 = new Title1846();
        int[] arr = new int[20001];
        for (int i = 0;i < 20001;i++){
            arr[i] = 209;
            if (i == 5000){
                i++;
                arr[i] = 10000;
            }
            if (i == 8000){
                i++;
                arr[i] = 1;
            }
        }
        System.out.println(title1846.maximumElementAfterDecrementingAndRearranging(arr));
    }
}

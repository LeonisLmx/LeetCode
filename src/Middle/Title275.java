package Middle;

import javafx.util.Pair;

/**
 * @Author: Urey
 * @Date: 2021/7/12
 */
public class Title275 {

    public int hIndex(int[] citations){
        int len = citations.length;
        int a = 0;
        for (int i = 1;i <= len;i++){
            if (citations[len - i] >= i){
                a = i;
            }else{
                break;
            }
        }
        return a;
    }

    public int hIndex2(int[] citations){
        int len = citations.length;
        int left = 0,right = len - 1;
        while (left < right){
            int mid = (left + right)/2;
            if (citations[mid] >= left - mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return len - left;
    }

    public static void main(String[] args) {
        Title275 title275 = new Title275();
        System.out.println(title275.hIndex(new int[]{0,1,3,5,6}));
        System.out.println(title275.hIndex(new int[]{0,1,4,5,6}));
        System.out.println(title275.hIndex(new int[]{1}));
        System.out.println(title275.hIndex(new int[]{0}));
        System.out.println(title275.hIndex(new int[]{100}));
        System.out.println(title275.hIndex(new int[]{0,1}));
        System.out.println(title275.hIndex(new int[]{11,15}));
        System.out.println(title275.hIndex(new int[]{0,0,1}));
    }
}

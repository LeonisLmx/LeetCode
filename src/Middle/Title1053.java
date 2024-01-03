package Middle;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author urey.liu
 * @description
 * @date 2023/4/3 2:18 下午
 */
public class Title1053 {

    public int[] prevPermOpt1(int[] arr) {
        int length = arr.length;
        for (int i = length - 2;i >=0 ;i--){
            if (arr[i] > arr[i + 1]){
                int k = length - 1;
                while (arr[k] >= arr[i] || arr[k] == arr[k - 1]){
                    k--;
                }
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Title1053 title1053 = new Title1053();
        System.out.println(Arrays.toString(title1053.prevPermOpt1(new int[]{3, 1, 1, 3})));
        System.out.println(Arrays.toString(title1053.prevPermOpt1(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(title1053.prevPermOpt1(new int[]{1, 1, 5})));
        System.out.println(Arrays.toString(title1053.prevPermOpt1(new int[]{1,9,4,6,7})));
//        System.out.println(Arrays.toString(title1053.prevPermOpt1(new int[]{66, 1, 31, 11, 36, 5, 59, 3, 61, 47, 36, 59, 93, 89, 92, 6, 36, 62, 46, 35, 35, 60, 59, 13, 55, 9, 49, 11, 95, 37, 57, 63, 10, 14, 61, 60, 85, 60, 92, 83, 61, 57, 86, 50, 85, 66, 61, 50, 52, 16, 61, 75, 81, 69, 82, 55, 29, 3, 84, 22, 43, 52, 76, 72, 30, 29, 59, 25, 80, 19, 52, 44, 87, 33, 11, 19, 48, 2, 92, 33, 18, 69, 83, 15, 66, 3, 93, 32, 8, 64, 61, 48, 84, 73, 93, 67, 28, 92, 10, 93, 67, 17, 22, 11, 37, 18, 9, 27, 75, 23, 13, 46, 68, 1, 73, 4, 75, 17, 68, 50, 6, 1, 55, 17, 47, 93, 70, 51, 37, 35, 45, 45, 17, 44, 49, 88, 55, 34, 4, 73, 17, 89, 5, 49, 20, 88, 76, 55, 31, 58, 17, 94, 2, 52, 72, 13, 51, 6, 15, 23, 59, 20, 82, 5, 27, 71, 59, 23, 12, 28, 93, 5, 20, 63, 36, 83, 84, 7, 78, 45, 49, 8, 95, 80, 11, 88, 21, 72, 66, 59, 72, 24, 8, 63, 82, 73, 70, 33, 74, 3, 87, 32, 11, 39, 88, 33, 92, 95, 33, 90, 72, 81, 5, 58, 85, 61, 77, 29, 87, 75, 44, 66, 13, 35, 32, 87, 39, 77, 44, 1, 91, 13, 8, 75, 72, 91, 23, 3, 86, 71, 30, 13, 85, 86, 17, 63, 11, 79, 89, 89, 5, 77, 55, 77, 43, 25, 50, 51, 23, 85, 71, 76, 25, 92, 21, 24, 74, 42, 8, 70, 22, 84, 17, 52, 81, 6, 46, 90, 68, 49, 51, 60, 35, 28, 26, 30, 41, 68, 5, 11, 20, 75, 56, 38, 80, 64, 27, 70, 42, 72, 63, 18, 57, 90, 7, 5, 49, 14, 14, 14, 16, 78, 52, 60, 87, 54, 89, 89, 41, 84, 80, 49, 39, 26, 75, 10, 20, 30, 72, 78, 28, 26, 7, 13, 36, 27, 27, 88, 87, 12, 76, 29, 33, 80, 56, 64, 86, 41, 57, 31, 86, 38, 7, 26, 71, 11, 92, 83, 3, 41, 39, 70, 16, 6, 86, 68, 4, 66, 20, 89, 2, 86, 29, 70, 77, 2, 93, 48, 2, 15, 70, 34, 66, 28, 20, 27, 82, 45, 81, 65, 11, 82, 19, 79, 12, 5, 66, 17, 25, 68, 30, 62, 73, 60, 71, 8, 52, 35, 72, 28, 13, 17, 79, 22, 60, 16, 83, 36, 35, 69, 1, 85, 91, 87, 51, 6, 55, 5, 49, 83, 31, 79, 89, 73, 59, 13, 40, 57, 27, 59, 71, 76, 78, 19, 93, 1, 29, 28, 88, 34, 9, 86, 46, 14, 44, 92, 87, 17, 45, 67, 19, 57, 65, 94, 34, 91, 37, 75, 8, 13, 88, 76, 50, 1, 44, 18, 55, 32, 22, 65, 42, 72, 56, 95, 22, 51, 28, 91, 81, 28, 50, 31, 55, 19, 50, 46, 47, 2, 78, 15, 59, 22, 71, 38, 60, 39, 90, 27, 11, 36, 57, 87})));
    }
}
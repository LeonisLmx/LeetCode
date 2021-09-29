package Simple;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/8/26
 */
public class Title88 {

    public void merge(int[] nums1,int m,int[] nums,int n){
        int[] arr = new int[m + n];
        int a = 0,b = 0,index = 0;
        while (a < m && b < n){
            if (nums[a] < nums[b]){
                arr[index] = nums1[a];
                a++;
            }else{
                arr[index] = nums[b];
                b++;
            }
            index++;
        }
        while (a < m){
            arr[index] = nums1[a];
            index++;
            a++;
        }
        while (b < n){
            arr[index] = nums[b];
            index++;
            b++;
        }
        for (int i = 0;i < m + n;i++){
            nums1[i] = arr[i];
        }
    }
}

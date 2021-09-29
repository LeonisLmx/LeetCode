package Simple;

import com.oracle.javafx.jmx.json.JSONReader;
import netscape.javascript.JSObject;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/5/31
 */
public class Title342 {

    public boolean isPowerOfFour(int n) {
        long a = 1;
        while (n > a){
            a = a << 2;
        }
        return a == n;
    }

    public static void partitionSort(){
        int[] arr = new int[]{8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length - 1,temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right,int[] temp) {
        if (left < right){
            int mid = (left + right) / 2;
            sort(arr,left,mid,temp);
            sort(arr,mid + 1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(int[] arr, int left,int middle, int right,int[] temp) {
        int a = 0,i = left,j = middle + 1;
        while (i <= middle && j <= right){
            if (arr[i] < arr[j]){
                temp[a++] = arr[i++];
            }else{
                temp[a++] = arr[j++];
            }
        }
        while (i <= middle){
            temp[a++] = arr[i++];
        }
        while (j <= right){
            temp[a++] = arr[j++];
        }
        a = 0;
        while (left <= right){
            arr[left++] = temp[a++];
        }
    }

    public void quickSort(){
        int[] arr = new int[]{8,4,5,7,1,3,6,2};
        int i = 0,j = arr.length;
        quickSortArr(arr,i,j);
    }

    private void quickSortArr(int[] arr, int i, int j) {
        while (i < j){
            //while (i < j && arr[i])
        }
    }

    public static void main(String[] args) {
        partitionSort();
    }
}

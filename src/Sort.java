import javafx.util.Pair;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/7/16
 */
public class Sort {

    public void bubblingSort(int[] arr){
        int len = arr.length;
        for (int i = 0;i < len;i++){
            for (int j = i;j < len;j++){
                if (arr[i] > arr[j]){
                    swap(arr,i,j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void selectSort(int[] arr){
        int len = arr.length;
        for (int i = 0;i < len;i++){
            int min = arr[i],index = i;
            for (int j = i + 1;j < len;j++){
                if (min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr,i,index);
        }
        System.out.println(Arrays.toString(arr));
    }

    public void insertSort(int[] arr){
        int len = arr.length;
        int[] arrs = new int[len];
        for (int i = 0;i < len;i++){
            arrs[i] = arr[i];
            for (int j = i;j > 0;j--){
                if (arrs[j] < arrs[j - 1]){
                    swap(arrs,j,j-1);
                }
            }
        }
        System.out.println(Arrays.toString(arrs));
    }

    public void mergeSort(int[] arr){
        int len = arr.length;
        int left = 0,right = len - 1;
        int[] arrs = new int[len];
        split(left,right,arr,arrs);
        System.out.println(Arrays.toString(arrs));
    }

    // 先把数组分割
    private void split(int left, int right, int[] arr,int[] arrs) {
        int mid = left + (right - left) / 2;
        if (left < right) {
            split(left, mid, arr,arrs);
            split(mid + 1, right, arr,arrs);
            merge_sort(left, mid, right, arr, arrs);
        }
    }

    // 数组归并排序
    private void merge_sort(int left,int mid,int right,int[] arr,int[] arrs) {
        int a = left,b = mid + 1,index = left;
        while (a <= mid && b <= right){
            if (arr[a] < arr[b]){
                arrs[index] = arr[a];
                a++;
            }else{
                arrs[index] = arr[b];
                b++;
            }
            index++;
        }
        while (a <= mid){
            arrs[index] = arr[a];
            a++;
            index++;
        }
        while (b <= right){
            arrs[index] = arr[b];
            b++;
            index++;
        }
        // 把排序过的数组拷贝回去
        index = left;
        while (left <= right){
            arr[index] = arrs[left];
            index++;
            left++;
        }
    }

    public void quickSort(int[] arr){
        int len = arr.length;
        int left = 0, right = len - 1;
        quick_sort(arr,left,right);
        System.out.println(Arrays.toString(arr));
    }

    private void quick_sort(int[] arr, int left, int right) {
        if (left < right) {
            int num = arr[left], index = left + 1;
            int a = left, b = right;
            left++;
            while (left <= right) {
                if (arr[left] < num) {
                    swap(arr, left, index);
                    index++;
                }
                left++;
            }
            swap(arr, a,index - 1);
            quick_sort(arr, a,index - 1);
            quick_sort(arr, index, b);
        }
    }

    public void swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        Sort sort = new Sort();
        sort.quickSort(arr);
    }
}

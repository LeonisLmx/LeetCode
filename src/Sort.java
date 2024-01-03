import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/7/16
 */
public class Sort {

    public void quickSort(int[] arr, int left, int right){
        if (left >= right) {
            return;
        }
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left;j < right;j++){
            if (arr[j] < pivot){
                i++;
                swap(i, j , arr);
            }
        }
        swap(i + 1, right, arr);
        quickSort(arr, left, i);
        quickSort(arr, i + 1, right);
    }

    public void swap(int i,int j,int[] arr){
        int res = arr[i];
        arr[i] = arr[j];
        arr[j] = res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,44,38,3,47,15,36,26,27,2,46,4,19,50,48};
        Sort sort = new Sort();
        sort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

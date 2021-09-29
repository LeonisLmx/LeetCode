package Simple;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/4/20
 */
public class Title1619 {

    public double trimMean(int[] arr){
        int length = arr.length,value = length % 20 == 0?length / 20:(length / 20) + 1,result = 0;
        if (length <= 2){
            return 0;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0;j < length;j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = value;i < length - value;i++){
            result = result + arr[i];
        }
        return (double)result / (length - value - value);
    }

    public int quickSort(int[] arr,int low,int high){
        int first = arr[low];
        while (low < high){
            low++;
            if (arr[low] < first){

            }
        }
        arr[low] = first;
        return low;
    }

    public static void main(String[] args) {
    }
}

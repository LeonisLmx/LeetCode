package Middle;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/8/12
 */
public class TItle1143 {

    // if i == j dp[i][j] = dp[i - 1][j - 1] + 1
    // dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1])
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1;i <= len1;i++){
            for (int j = 1;j <= len2;j++){
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    static int[] dp;
    public static void mergeSort(int[] arr){
        int length = arr.length;
        dp = new int[length];
        split(0,length - 1,arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void split(int left,int right,int[] arr){
        if (right - left > 1){
            int mid = left + (right - left) / 2;
            split(left,mid,arr);
            split(mid + 1,right,arr);
            merge(left,mid,right,arr);
        }else{
            swap(left,right,arr);
        }
    }

    private static void swap(int left, int right, int[] arr) {
        if (arr[left] > arr[right]){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    public static void merge(int left,int mid,int right,int[] arr){
        int start = left;
        int index = 0,temp = mid + 1;
        while (left <= mid && temp <= right){
            if (arr[left] < arr[temp]){
                dp[index] = arr[left];
                left++;
            }else{
                dp[index] = arr[temp];
                temp++;
            }
            index++;
        }
        while (left <= mid){
            dp[index] = arr[left];
            left++;
            index++;
        }
        while (temp <= right){
            dp[index] = arr[temp];
            temp++;
            index++;
        }
        index = 0;
        for (int i = start;i <= right;i++){
            arr[i] = dp[index];
            index++;
        }
        Arrays.fill(dp,0);
    }

    public static void quickSort(int[] arr){
        int len = arr.length;
        sort(0,len - 1,arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int left, int right, int[] arr) {
        if (left >= right){
            return;
        }
        int start = left,index = left + 1;
        left++;
        while (left <= right){
            if (arr[start] > arr[left]){
                swap(index,left,arr);
                index++;
            }
            left++;
        }
        swap(start,index - 1,arr);
        sort(start,index - 1,arr);
        sort(index,right,arr);
    }

    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("abcde","ace"));
//        System.out.println(longestCommonSubsequence("abc","abc"));
//        System.out.println(longestCommonSubsequence("abc","def"));
//        System.out.println(longestCommonSubsequence("ezupkr","ubmrapg"));
//        System.out.println(longestCommonSubsequence("bsbininm","jmjkbkjkv"));
       // mergeSort(new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48});
        quickSort(new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48});
    }
}

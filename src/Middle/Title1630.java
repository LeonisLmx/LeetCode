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
        for (int i = 0;i < l.length;i++){
            if (r[i] - l[i] <= 1){
                list.add(true);
            }else{
                list.add(checkArr(nums,l[i],r[i]));
            }
        }
        return list;
    }

    private Boolean checkArr(int[] nums, int i, int j) {
        int[] arr = new int[j - i + 1];
        int res = 0;
        while (i <= j){
            arr[res] = nums[i];
            res++;
            i++;
        }
        Arrays.sort(arr);
        for (int z = 2;z < arr.length;z++){
            if (arr[z] - arr[z - 1] != arr[z - 1] - arr[z - 2]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Title1630 title1630 = new Title1630();
        System.out.println(title1630.checkArithmeticSubarrays(new int[]{4,6,5,9,3,7},new int[]{0,0,2},new int[]{2,3,5}));
    }
}

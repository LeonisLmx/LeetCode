package Middle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Urey
 * @Date: 2021/7/14
 */
public class Title1818 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length,a = 1000000007,maxn = 0;
        long sum = 0;
        List<Integer> list = Arrays.stream(nums1).sorted().boxed().collect(Collectors.toList());
        for (int i = 0;i < len;i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = sum + diff;
            int temp = findAbsNum(list,nums2[i],0,len - 1,a);
            // temp 如果是 -1，那就说明没找到合适的结果
            if (temp >= 0){
                maxn = Math.max(maxn,diff - temp);
            }
        }
        return (int)((sum - maxn) % a);
    }

    private int findAbsNum(List<Integer> list, int num, int left,int right,int a) {
        while (left < right){
            int mid = left + (right - left) / 2;
            if (list.get(mid) == num){
                return 0;
            }
            if (list.get(mid) < num){
                left = mid;
            }else{
                right = mid;
            }
            if (left + 1 == right){
                return Math.min(Math.abs(list.get(left) - num),Math.abs(list.get(right) - num));
            }
        }
        return Math.abs(list.get(left) - num);
    }

    public static void main(String[] args) {
        Title1818 title1818 = new Title1818();
//        System.out.println(title1818.minAbsoluteSumDiff(new int[]{1,7,5},new int[]{2,3,5}));
//        System.out.println(title1818.minAbsoluteSumDiff(new int[]{1,28,21},new int[]{9,21,20}));
        System.out.println(title1818.minAbsoluteSumDiff(new int[]{150,100},new int[]{90,10}));
    }
}

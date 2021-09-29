package Hard;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2020/12/2
 */
public class Title321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[]  a = new int[k];
        Arrays.fill(a,-1);
        revert(a,nums1,nums2,-1,nums1.length,-1,nums2.length,0);
        return a;
    }

    private void revert(int[] a, int[] nums1, int[] nums2, int start1,int end1,int start2,int end2,int num) {
        if (num >= a.length){
            return;
        }
        int s1 = -1,s2 =  -1,amax = -1,bmax = -1;
        for (int i = Math.max(start1,0); i < end1; i++) {
            if (nums1[i] > amax){
                s1 = i;
                amax = nums1[i];
            }
        }
        for (int i = Math.max(start2,0); i < end2; i++) {
            if (nums2[i] > bmax){
                s2 = i;
                bmax = nums2[i];
            }
        }
        a[num] = Math.max(amax,bmax);
        // 两者的最大值相等的情况，往前找，直到找到比较小的那个，用小的那个当最大数
        if (amax == bmax){
            int temp1 = s1 - 1,temp2 = s2 - 1;
            while (temp1 > start1 && temp2 > start2){
                // 用s1
                if (nums1[temp1] < nums2[temp2]){
                    s2 = -1;
                    break;
                }else if (nums1[temp1] > nums2[temp2]){
                    // 用 s2
                    s1 = -1;
                    break;
                }else{
                    temp1--;
                    temp2--;
                }
            }
            // 说明是最小了。用s1
            if (s1 >= 0 && s2 >= 0) {
                if (temp1 < start1) {
                    s2 = -1;
                } else {
                    // 用s2
                    s1 = -1;
                }
            }
        }else{
            if (amax < bmax){
                s1 = -1;
            }else{
                s2 = -1;
            }
        }
        end1 =  nums1.length;
        end2 = nums2.length;
        // 说明剩下的长度不够了。
        if (nums1.length - Math.max(Math.max(start1,s1),0)  +  nums2.length - Math.max(Math.max(start2,s2),0) <  a.length - num){
            a[num] = -1;
            end1 = s1 == -1?start1:s1;
            end2 = s2 == -1?start2:s2;
        }else {
            num = num + 1;
            start1 =  s1 == -1?start1:s1 + 1;
            start2 =  s2 == -1?start2:s2 + 1;
        }
        revert(a,nums1,nums2,start1,end1,start2,end2,num);
    }

    public static void main(String[] args) {
        Title321 title321 = new Title321();
        System.out.println(Arrays.toString(title321.maxNumber(new int[]{3, 4, 6, 5},new int[]{9, 1, 2, 5, 8, 3},3)));
        System.out.println(Arrays.toString(title321.maxNumber(new int[]{3, 4, 6, 5},new int[]{9, 1, 2, 5, 8, 3},5)));
        System.out.println(Arrays.toString(title321.maxNumber(new int[]{3, 9},new int[]{8, 9},3)));
        System.out.println(Arrays.toString(title321.maxNumber(new int[]{6, 7},new int[]{6, 0, 4},5)));
        System.out.println(Arrays.toString(title321.maxNumber(new int[]{8, 9},new int[]{3, 9},3)));
        System.out.println(Arrays.toString(title321.maxNumber(new int[]{5, 1, 0},new int[]{5, 2 ,1},3)));
        System.out.println(Arrays.toString(title321.maxNumber(new int[]{2,2,0,6,8,9,6},new int[]{5,2,4,5,3,6,2},7)));
    }
}

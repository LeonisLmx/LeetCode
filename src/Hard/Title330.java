package Hard;

/**
 * @Author: Urey
 * @Date: 2020/12/29
 * 1 可以称重量 < 2的
 * 1，2 可以称重量 < 4的
 * 1，2，4 可以称重量 < 8的
 * ...
 * 1,2,4,n 可以称重量 < 2n的
 */
public class Title330 {

    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long  x = 1;
        int length = nums.length, index = 0;
        while (x <= n){
            if (index < length && nums[index]  <= x){
                x = x + nums[index];
                index++;
            }else{
                x = x * 2;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        Title330 title330 = new Title330();
        System.out.println(title330.minPatches(new int[]{1,3},6));
    }
}

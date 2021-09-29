package Middle;

/**
 * @Author: Urey
 * @Date: 2021/4/8
 */
public class Title153 {

    /**
     * 3,4,5,1,2
     * @param nums
     * @return
     */
    public int findMin(int[] nums){
        int j = nums.length - 1;
        // 说明本身就是一个正序数组
        if (nums[0] < nums[j]){
            return nums[0];
        }
        while (j > 0){
            if (nums[j] < nums[j - 1]){
                return nums[j];
            }
            j--;
        }
        return nums[j];
    }

    public static void main(String[] args) {

    }
}

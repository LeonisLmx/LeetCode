package Simple;

/**
 * @Author: Urey
 * @Date: 2021/9/6
 */
public class Title704 {

    public int search(int[] nums,int target){
        int left = 0,right = nums.length - 1;
        while (left < right){
            int middle = left + (right - left) / 2;
            if (nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle;
            }
        }
        return nums[left] == target?left:-1;
    }
}

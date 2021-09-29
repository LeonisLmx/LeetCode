package offer;

/**
 * @Author: Urey
 * @Date: 2021/7/16
 */
public class Title53_01 {

    public int search(int[] nums,int target){
        int index = biarnSearch(nums,target,0,nums.length),count = 1;
        if (index == -1){
            return 0;
        }
        int i = index - 1,j = index + 1;
        while (i > 0 && nums[i] == target){
            count++;
        }
        while (j < nums.length && nums[j] == target){
            count++;
        }
        return count;
    }

    private int biarnSearch(int[] nums, int target,int left,int right) {
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}

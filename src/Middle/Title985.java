package Middle;

/**
 * @Author: Urey
 * @Date: 2021/8/24
 */
public class Title985 {

    public int[] sumEventAfterQueries(int[] nums,int[][] queries){
        int len = queries.length;
        int[] arr = new int[len];
        int result = 0;
        for (int num : nums) {
            if (num % 2 == 0){
                result += num;
            }
        }
        for (int i = 0;i < len;i++){
            int index = queries[i][1];
            if (nums[index] % 2 == 0){
                result -= nums[index];
            }
            nums[index] = nums[index] + queries[i][0];
            if (nums[index] % 2 == 0){
                result += nums[index];
            }
            arr[i] = result;
        }
        return arr;
    }
}

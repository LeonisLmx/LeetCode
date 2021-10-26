package Simple;

import java.util.Arrays;

// 15,21,35,49,77,83,86,86,92,93
public class Title453 {

    public static int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        while (nums[0] != nums[nums.length - 1]){
            int diff = nums[nums.length - 1] - nums[0];
            count += diff;
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 1; i--) {
                nums[i] = nums[i - 1] + diff;
            }
            nums[0] = temp;
        }
        return count;
    }

    public int minMoves2(int[] nums){
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1,2,3}));
        System.out.println(minMoves(new int[]{83,86,77,15,93,35,86,92,49,21}));
    }
}

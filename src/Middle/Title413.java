package Middle;

/**
 * @Author: Urey
 * @Date: 2021/8/10
 */
public class Title413 {

    public int numberOfArithmeticSlices(int[] nums){
        int[] arr = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            arr[i - 1] = nums[i] - nums[i - 1];
        }
        int result = 0;
        loop:
        for (int i = 0;i < arr.length;i++){
            for (int j = i + 1;j < arr.length;j++){
                if (arr[i] == arr[j]){
                    result++;
                }else{
                    continue loop;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Title413 title413 = new Title413();
        System.out.println(title413.numberOfArithmeticSlices(new int[]{1}));
    }
}

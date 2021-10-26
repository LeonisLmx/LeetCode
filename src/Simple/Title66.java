package Simple;

public class Title66 {

    public int[] plusOne(int[] digits) {
        int[] nums = new int[digits.length];
        int last = 1;
        for (int i = digits.length - 1;i >=0 ;i--){
            if (digits[i] + last > 10){
                nums[i] = digits[i] + last - 10;
                last = 1;
            }else{
                nums[i] = digits[i] + last;
            }
        }
        if (last > 0){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }else{
            return nums;
        }
    }
}

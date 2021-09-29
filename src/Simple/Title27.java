package Simple;

/**
 * @Author: Urey
 * @Date: 2021/4/20
 */
public class Title27 {

    public int removeElement(int[] nums,int val){
        int result = 0,i = 0,j = nums.length - 1,temp;
        while (i <= j){
            if (nums[i] == val){
                result++;
                while (nums[j] == val && i < j){
                    result++;
                    j--;
                }
                if (i == j){
                    return nums.length - result;
                }
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }
            i++;
        }
        return nums.length - result;
    }

    public static void main(String[] args) {
        Title27 title27 = new Title27();
        System.out.println(title27.removeElement(new int[]{3,2,2,3},3));
        System.out.println(title27.removeElement(new int[]{0,1,2,2,3,0,4,2},2));
        System.out.println(title27.removeElement(new int[]{1},1));
    }
}

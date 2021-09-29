package Middle;

/**
 * @Author: Urey
 * @Date: 2021/5/28
 */
public class Title477 {

    public int totalHanmingDistance(int[] nums){
        int ans = 0;
        for (int i = 1;i < 32;i++){
            int a = 0,b = 0;
            for (int num : nums) {
                if(((num >> i) & 1) == 0){
                    a++;
                }else{
                    b++;
                }
            }
            ans = ans + a * b;
        }
        return ans;
    }

    public static void main(String[] args) {
        Title477 title477 = new Title477();
        System.out.println(title477.totalHanmingDistance(new int[]{4,14,2}));
    }
}

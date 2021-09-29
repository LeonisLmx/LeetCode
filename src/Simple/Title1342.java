package Simple;

/**
 * @Author: Urey
 * @Date: 2021/5/10
 */
public class Title1342 {

    private static int result = 0;

    public int numberOfSteps(int num){
        revert(num);
        return result;
    }

    private void revert(int num) {
        if (num == 0){
            return;
        }
        result++;
        if (num % 2 == 1){
            num -=1;
        }else{
            num = num >> 1;
        }
        System.out.println(num);
        revert(num);
    }
}

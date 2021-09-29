package Simple;

/**
 * @Author: Urey
 * @Date: 2021/8/9
 */
public class Title263 {

    public boolean isUgly(int n){
        while (n > 1){
            if (n % 2 == 0){
                n = n / 2;
            }else if (n % 3 == 0){
                n = n / 3;
            }else if (n % 5 == 0){
                n = n / 5;
            }else{
                return false;
            }
        }
        return n == 1;
    }
}

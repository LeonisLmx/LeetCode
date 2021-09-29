package Simple;

/**
 * @Author: Urey
 * @Date: 2021/9/7
 */
public class Title1221 {

    public int balancedStringSplit(String s){
        int result = 0,a = 0,b = 0,len = s.length();
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == 'L'){
                a++;
            }else{
                b++;
            }
            if (a == b){
                result++;
                a = b = 0;
                len -= i;
            }
            if (a > len / 2 || b > len / 2){
                result++;
                break;
            }
        }
        return result;
    }
}

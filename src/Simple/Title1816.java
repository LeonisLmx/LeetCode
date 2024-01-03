package Simple;

/**
 * @author urey.liu
 * @description
 * @date 2021/12/6 10:31 上午
 */
public class Title1816 {

    public String truncateSentence(String s, int k) {
        String[] res = s.split(" ");
        int str = 0;
        for (int i = 0;i < k;i++){
            str += res[i].length();
            str++;
        }
        return s.substring(0,str - 1);
    }
}

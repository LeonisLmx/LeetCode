package Simple;

/**
 * @Author: Urey
 * @Date: 2020/12/3
 */
public class Title204 {

    public int countPrimes(int n) {
        int s = 0;
        if (n >= 2){
            s++;
        }
        loop:
        for (int i = 3;i < n;i+=2){
            int k = (int)Math.sqrt(i);
            for (int j = 2;j <= k;j++){
                if (i %  j == 0){
                    continue loop;
                }
            }
            s++;
        }
        return s;
    }

    public static void main(String[] args) {
        Title204 title204 = new Title204();
        System.out.println(title204.countPrimes(10));
    }
}

package Middle;

/**
 * @author urey.liu
 * @description
 * @date 2022/10/20 3:45 下午
 */
public class Title779 {

    public static int kthGrammar(int n, int k) {
        if (k == 1){
            return 0;
        }
        boolean res = true;
        for (int i = 30;i > 0;i--){
            if (k > Math.pow(2,i - 1)){
                k = k - (int)Math.pow(2, i -1);
                res = !res;
            }
        }
        return res?0:1;
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(1,1));
        System.out.println(kthGrammar(2,1));
        System.out.println(kthGrammar(2,2));
        System.out.println(kthGrammar(4,10));
        System.out.println(kthGrammar(4,12));
    }
}

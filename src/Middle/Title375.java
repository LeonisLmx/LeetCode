package Middle;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/12 11:41 上午
 */
public class Title375 {

    public int getMoneyAmount(int n){
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = i + f[i + 1][j];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }

    public static void main(String[] args) {
        Title375 title375 = new Title375();
        System.out.println(title375.getMoneyAmount(10));
        System.out.println(title375.getMoneyAmount(1));
        System.out.println(title375.getMoneyAmount(2));
        System.out.println(title375.getMoneyAmount(3));
        System.out.println(title375.getMoneyAmount(4));
    }
}

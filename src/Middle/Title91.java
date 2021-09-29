package Middle;

/**
 * @Author: Urey
 * @Date: 2021/4/21
 */
public class Title91 {

    // 11106

    /**
     * @param s
     * @return
     * 不计算当前数字
     * dp[0][n] = dp[1][n - 1]
     * 计算当前数字
     * dp[1][n] = Math.max(dp[1][n - 1],dp[0][n - 1]) + 1
     */
    public int numDecodings(String s){
        if (s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        Title91 title91 = new Title91();
        System.out.println(title91.numDecodings("12"));
    }
}

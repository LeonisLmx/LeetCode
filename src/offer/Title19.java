package offer;

/**
 * @Author: Urey
 * @Date: 2021/1/15
 * if s[i] == p[j]  dp[i][j] = dp[i - 1][j - 1]
 * if p[j] == '*' if s[i] != p[j - 1] dp[i][j] = dp[i][j - 2]
 *                otherwise s[i] == p[j - 1] dp[i][j] = dp[i - 1][j - 2]
 */
public class Title19 {
    public boolean isMatch(String s, String p) {
        int n = s.length(),m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0;i <= n;i++){
            for (int j = 0;j <= m;j++){
                if (j == 0){
                    dp[i][j] = i == 0;
                }else {
                    if (p.charAt(j - 1) == '*') {
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];
                        }
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')){
                            dp[i][j] |= dp[i-1][j];
                        }
                    } else {
                        if (i > 0 && s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Title19 title19 = new Title19();
//        System.out.println(title19.isMatch("aa","a"));
//        System.out.println(title19.isMatch("aa","a*"));
//        System.out.println(title19.isMatch("ab",".*"));
//        System.out.println(title19.isMatch("aab","c*a*b"));
//        System.out.println(title19.isMatch("mississippi","mis*is*p*."));
        System.out.println(title19.isMatch("aaa","a*a"));
        //System.out.println(title19.isMatch("aaab","a*ab"));
    }
}

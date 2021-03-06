package Middle;

/**
 * @Author: Urey
 * @Date: 2021/8/12
 */
public class Title516 {

    // if s[i] == s[j],dp[i][j] = dp[i + 1][j - 1] + 2
    // if s[i] != s[j],dp[i][j] = Math.max(dp[i][j - 1],dp[i + 1][j])
    public int longestPalindromeSubseq(String s){
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1;i >= 0;i--){
            dp[i][i] = 1;
            for (int j = i + 1;j < length;j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i + 1][j]);
                }
            }
        }
        return dp[0][length - 1];
    }

    public static int longestPalindromeSubseq2(String s){
        int length = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 1;i <= length;i++){
            for (int j = 1;j <= length;j++){
                if (s.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[length][length];
    }

    public static void main(String[] args) {
        Title516 title516 = new Title516();
        System.out.println(title516.longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq2("bbbab"));
    }
}

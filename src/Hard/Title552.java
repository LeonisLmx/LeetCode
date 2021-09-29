package Hard;

/**
 * @Author: Urey
 * @Date: 2021/8/18
 */
public class Title552 {

    // n 个 p
    // -> 1个a 0个L 1个a 1个L
    // -> 1个L
    // -> 2个L
    static long count = 0;

    public static int checkRecord(int n){
        count = 0;
        int mod = (int)Math.pow(10,9) + 7;
        checkRecords(n,0,"",0,0);
        return (int)count % mod;
    }

    private static void checkRecords(int n,int index,String s,int aCount,int lCount) {
        if (index == n){
            count++;
            return;
        }
        checkRecords(n,index + 1,s + "P",aCount,0);
        if (lCount < 2) {
            checkRecords(n, index + 1, s + "L", aCount, lCount + 1);
        }
        if (aCount < 1) {
            checkRecords(n, index + 1, s + "A", aCount + 1, 0);
        }
    }

    public int checkRecord2(int n){
        int mod = (int)Math.pow(10,9) + 7;
        // n + 1表示长度，第二个表示A的数量，第三个表示L的结尾数量
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1;i <= n;i++){
            // 以P结尾的
            for (int j = 0;j <= 1;j++){
                for (int k = 0;k <= 2;k++){
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % mod;
                }
            }
            // 以A结尾的
            for (int k = 0;k <= 2;k++){
                // 既然以A为结尾，那么A必定是1
                // 上一个数字可以是任何数字结尾的，也就是说以L结尾的可以是0/1/2，所以要遍历 <= 2
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % mod;
            }
            // 以L结尾的,L可能是1，也可能是2，A的数量可能是0，也可能是1
            for (int j = 0;j <= 1;j++){
                for (int k = 1;k <= 2;k++){
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % mod;
                }
            }
        }
        int sum = 0;
        for (int j = 0;j <= 1;j++){
            for (int k = 0;k <= 2;k++){
                sum = (sum + dp[n][j][k]) % mod;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord(2));
        System.out.println(checkRecord(3));
        System.out.println(checkRecord(10101));
    }
}

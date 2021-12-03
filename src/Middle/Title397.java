package Middle;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/19 10:11 上午
 */
public class Title397 {

    int count = 0;

    public int integerReplacement(int n){
        count = 0;
        dfs(n);
        return count;
    }

    private void dfs(int n) {
        char[] res = Integer.toBinaryString(n).toCharArray();
        int length = res.length,i = length - 1;
        while (i > 0){
            if (n == 3){
                count += 2;
                return;
            }
            if (res[i] == '0'){
                i--;
                n = n / 2;
                count++;
            }else{
                if (res[i - 1] == '1'){
                    n = n + 1;
                }else{
                    n = n - 1;
                }
                count++;
                dfs(n);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Title397 title397 = new Title397();
        System.out.println(title397.integerReplacement(8));
        System.out.println(title397.integerReplacement(7));
        System.out.println(title397.integerReplacement(4));
        System.out.println(title397.integerReplacement(65535));
        System.out.println(title397.integerReplacement(3));
    }
}

package Middle;

/**
 * @Author: Urey
 * @Date: 2020/12/15
 */
public class Title738 {

    public int monotoneIncreasingDigits2(int N) {
        char[] chars = (N + "").toCharArray();
        boolean flag = true;int i = chars.length - 1;
        while (true){
            for (int j = chars.length - 1; j >= 0; j--) {
                if (j > 0 && chars[j] < chars[j - 1]){
                    i--;
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag){
                return Integer.parseInt(new String(chars));
            }
            chars[i] = (char)(chars[i] - 1);
            chars[i + 1] = '9';
        }
    }

//    private int dfs(char[] chars, int i) {
//        if (i < chars.length - 1){
//            chars[i] = (char)(chars[i] - 1);
//            chars[i + 1] = '9';
//        }
//        boolean flag = true;
//        for (int j = chars.length - 1; j >= 0; j--) {
//            if (j > 0 && chars[j] < chars[j - 1]){
//                i--;
//                flag = false;
//                break;
//            }
//        }
//        if (!flag) {
//            return dfs(chars, i);
//        }else{
//            return Integer.parseInt(new String(chars));
//        }
//    }

    public int monotoneIncreasingDigits(int N) {
        char[] chars = (N + "").toCharArray();
        int k = chars.length;
        for (int j = chars.length - 1; j >= 1; j--) {
            if (chars[j] < chars[j - 1]){
                chars[j - 1] = (char)(chars[j - 1] - 1);
                chars[j] = '9';
                k = j + 1;
            }
        }
        for (int i = k; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        Title738 title738 = new Title738();
        //System.out.println(title738.monotoneIncreasingDigits(10));
        System.out.println(title738.monotoneIncreasingDigits(1234));
        System.out.println(title738.monotoneIncreasingDigits(332));
        System.out.println(title738.monotoneIncreasingDigits(100));
        System.out.println(title738.monotoneIncreasingDigits(2134));
        System.out.println(title738.monotoneIncreasingDigits(20));
    }
}

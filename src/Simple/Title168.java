package Simple;

/**
 * @Author: Urey
 * @Date: 2021/6/29
 */
public class Title168 {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder("");
        while (columnNumber / 26 > 26){
            int a = columnNumber % 26;
            columnNumber = columnNumber / 26;
            if (a == 0){
                sb.append('Z');
                columnNumber--;
            }else {
                sb.append((char)(a + 64));
            }
        }
        int m = columnNumber / 26;
        int n = columnNumber % 26;
        if (n > 0){
            sb.append((char)(n + 64));
        }
        if (m > 0){
            if (n == 0){
                sb.append('Z');
                if (m > 1) {
                    sb.append((char) (m - 1 + 64));
                }
            }else {
                sb.append((char) (m + 64));
            }
        }
        return sb.reverse().toString();
    }

    public String convertToTitle2(int columnNumber){
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0){
            columnNumber--;
            sb.append((char) ((columnNumber % 26) + 'A'));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Title168 title168 = new Title168();
        System.out.println(title168.convertToTitle(2));
        System.out.println(title168.convertToTitle(701));
        System.out.println(title168.convertToTitle(2147483647));
        System.out.println(title168.convertToTitle(26));
        System.out.println(title168.convertToTitle(52));
        System.out.println(title168.convertToTitle(702));
    }
}

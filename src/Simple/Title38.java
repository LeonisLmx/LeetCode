package Simple;

/**
 * @Author: Urey
 * @Date: 2020/12/1
 */
public class Title38 {
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        String s = countAndSay(n - 1);
        char last = s.charAt(0);
        int num = 1;
        StringBuilder sb = new StringBuilder("");
        for (int i = 1;i < s.length();i++){
            if (s.charAt(i) != last){
                sb.append(num).append(last);
                last = s.charAt(i);
                num = 1;
            }else{
                num++;
            }
        }
        return sb.append(num).append(last).toString();
    }

    public static void main(String[] args) {
        Title38 title38 = new Title38();
        System.out.println(title38.countAndSay(30));
    }
}

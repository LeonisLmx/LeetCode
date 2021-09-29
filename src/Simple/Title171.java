package Simple;

/**
 * @Author: Urey
 * @Date: 2021/7/30
 */
public class Title171 {

    public int titleToNumber(String columnTitle){
        int len = columnTitle.length();
        int result = 0,index = 0;
        for (int i = len - 1;i >= 0;i--){
            result = result + (columnTitle.charAt(i) - 64) * (int)Math.pow(26,index);
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Title171 title171 = new Title171();
        System.out.println(title171.titleToNumber("A"));
        System.out.println(title171.titleToNumber("AB"));
        System.out.println(title171.titleToNumber("ZY"));
        System.out.println(title171.titleToNumber("FXSHRXW"));
    }
}

package Simple;

/**
 * @Author: Urey
 * @Date: 2021/4/20
 */
public class Title28 {

    public int strStr(String haystack,String needle){
        if ("".equals(needle)){
            return 0;
        }
        loop:
        for (int i = 0;i <= haystack.length() - needle.length();i++){
            int result = 0;
            for (int j = 0;j < needle.length();j++){
                if (haystack.charAt(i + result) != needle.charAt(j)){
                    continue loop;
                }
                result++;
            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Title28 title28 = new Title28();
        System.out.println(title28.strStr("hello","ll"));
        System.out.println(title28.strStr("aaaaa","bba"));
        System.out.println(title28.strStr("",""));
        System.out.println(title28.strStr("hello","lo"));
    }
}

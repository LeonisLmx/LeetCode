package Hard;

/**
 * @author urey.liu
 * @description
 * cab abac
 * str1 + str2
 * str2 + str1
 * @date 2023/3/28 3:01 下午
 */
public class Title1092 {

    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1.contains(str2)){
            return str1;
        }
        if (str2.contains(str1)){
            return str2;
        }
        int n = str1.length(),m = str2.length();
        return "";
    }

    public String commonStr(String str1, String str2){
        String res = "";
        int i = 0,j = 0;
        while (i < str1.length() && j < str2.length()){
            if (str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else{
                if (i > 0) {
                    String str = str1.substring(0, i - 1);
                    res = str.length() > res.length()?str:res;
                }
                i++;
                j = 0;
            }
        }
        return res;
    }
}

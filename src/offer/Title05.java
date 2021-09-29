package offer;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2020/12/10
 */
public class Title05 {
//    public String replaceSpace(String s) {
//        int len = s.length();
//        StringBuilder sb = new StringBuilder("");
//        for (int i = 0;i < len;i++){
//            if (s.charAt(i) == ' '){
//                sb.append("%20");
//            }else{
//                sb.append(s.charAt(i));
//            }
//        }
//        return sb.toString();
//    }

    public String replaceSpace(String s) {
        int len = s.length(),index = len;
        for (int i = 0;i < len;i++){
            if (s.charAt(i) == ' '){
                index = index + 2;
            }
        }
        String[] strings = new String[index];
        while (len < index){
            if (s.charAt(len - 1) == ' '){
                strings[index - 1] = "0";
                strings[index - 2] = "2";
                strings[index - 3] = "%";
                index = index - 3;
            }else{
                strings[index - 1] = s.charAt(len - 1) + "";
                index--;
            }
            len--;
        }
        while (index > 0){
            index--;len--;
            strings[index] = s.charAt(len) + "";
        }
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Title05 title05 = new Title05();
        System.out.println(title05.replaceSpace("We are happy."));
    }
}

package Middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/5/17
 */
public class Title12 {

    private static final Map<Integer,String> map = new HashMap<>();

    static{
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder("");
        int a = num / 1000;
        appendStr(sb,a,1000);
        // num此时必定小于1000
        num = num % 1000;
        num = appendByNum(sb,num,100);
        num = appendByNum(sb,num,10);
        appendByNum(sb,num,1);
        return sb.toString();
    }

    private int appendByNum(StringBuilder sb,int num,int index){
        int b = num / index;
        if (b >= 5){
            if (b == 9){
                sb.append(map.get(index * 9));
                b -= 9;
            }else{
                sb.append(map.get(index * 5));
                b -= 5;
            }
        }
        if (b == 4){
            sb.append(map.get(index * 4));
        }else{
            appendStr(sb,b,index);
        }
        return num % index;
    }

    private void appendStr(StringBuilder sb,int n,int key){
        for (int i = 0;i < n;i++){
            sb.append(map.get(key));
        }
    }

    public static void main(String[] args) {
        Title12 title12 = new Title12();
        System.out.println(title12.intToRoman(3));
        System.out.println(title12.intToRoman(4));
        System.out.println(title12.intToRoman(9));
        System.out.println(title12.intToRoman(58));
        System.out.println(title12.intToRoman(1994));
    }
}

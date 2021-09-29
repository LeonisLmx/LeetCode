package Middle;

import java.math.BigInteger;

/**
 * @Author: Urey
 * @Date: 2021/9/26
 */
public class Title371 {

    public int getSum(int a,int b){
        StringBuilder n = new StringBuilder(Integer.toBinaryString(a)).reverse();
        StringBuilder m = new StringBuilder(Integer.toBinaryString(b)).reverse();
        int len = Math.max(n.length(),m.length());
        if (n.length() != m.length()){
            while (n.length() < m.length()){
                n.append("0");
            }
            while (m.length() < n.length()){
                m.append("0");
            }
        }
        StringBuilder sb = new StringBuilder("");
        boolean next = false;
        for (int i = 0;i < len;i++){
            if (n.charAt(i) == m.charAt(i)){
                sb.append(next?"1":"0");
                // 说明两个都是0，判断是否需要进一即可
                if (n.charAt(i) == '0'){
                    next = false;
                }else{
                    next = true;
                }
            }else{
                // 说明两个不同
                if (next){
                    sb.append("0");
                    next = true;
                }else{
                    sb.append("1");
                }
            }
        }
        if (next){
            sb.append("1");
        }
        sb.reverse();
        if (sb.length() >= 32 && sb.charAt(0) == '1'){
            BigInteger bi = new BigInteger(sb.toString(),2);
            return bi.intValue();
        }else {
            return Integer.parseInt(sb.toString(), 2);
        }
    }

    public static void main(String[] args) {
        Title371 title371 = new Title371();
        System.out.println(title371.getSum(-1,1));
    }
}

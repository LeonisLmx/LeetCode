package Middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/8 10:21 上午
 */
public class Title299 {

    public String getHint(String secret,String guess){
        int a = 0,b = 0;
        Map<Character,Integer> aMap = new HashMap<>();
        Map<Character,Integer> bMap = new HashMap<>();
        for (int i = 0;i < secret.length();i++){
            if (secret.charAt(i) == guess.charAt(i)){
                a++;
            }else{
                if (bMap.getOrDefault(secret.charAt(i),0) > 0){
                    b++;
                    bMap.merge(secret.charAt(i),-1,Integer::sum);
                }else{
                    aMap.merge(secret.charAt(i),1,Integer::sum);
                }
                if (aMap.getOrDefault(guess.charAt(i),0) > 0){
                    b++;
                    aMap.merge(guess.charAt(i),-1,Integer::sum);
                }else{
                    bMap.merge(guess.charAt(i),1,Integer::sum);
                }
            }
        }
        return String.format("%dA%dB",a,b);
    }

    public static void main(String[] args) {
        Title299 title299 = new Title299();
        System.out.println(title299.getHint("1122","2211"));
    }
}

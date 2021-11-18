package Middle;

import java.util.Arrays;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/15 3:05 下午
 * 1 1 1
 * 1 0 1
 * 1 0 0
 */
public class Title319 {

    public int bulbSwitch(int n){
        if (n == 0){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Title319 title319 = new Title319();
        System.out.println(title319.bulbSwitch(3));
        System.out.println(title319.bulbSwitch(0));
        System.out.println(title319.bulbSwitch(1));
    }
}

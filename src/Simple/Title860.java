package Simple;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2020/12/10
 */
public class Title860 {

    int a1 = 0,a2 = 0;

    public boolean lemonadeChange(int[] bills) {
        // a1 5的数量，a2 10的数量,a3 20的数量
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5){
                a1++;
            }else {
                if (bills[i] == 10){
                    a2++;
                }
                boolean isSuccess = substractMoney(bills[i] - 5);
                if (!isSuccess){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean substractMoney(int bill) {
        while(bill >= 10 && a2 > 0){
            bill = bill - 10;
            a2--;
        }
        while (bill >= 5 && a1 > 0){
            bill = bill - 5;
            a1--;
        }
        return bill == 0;
    }
    
    public boolean lemonadeChange2(int[] bills){
        int s1 = 0,s2 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 10){
                s2++;
                if (s1 == 0){
                    return false;
                }
                s1--;
            }else if (bills[i] == 20){
                if (s2 == 0){
                    if (s1 < 3){
                        return false;
                    }
                    s1 = s1 - 3;
                }else{
                   if (s1 == 0){
                       return false;
                   }
                   s1--;
                   s2--;
                }
            }else{
                s1++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Title860 title860 = new Title860();
//        System.out.println(title860.lemonadeChange(new int[]{5,5,5,10,20}));
//        System.out.println(title860.lemonadeChange(new int[]{5,5,10}));
//        System.out.println(title860.lemonadeChange(new int[]{10,10}));
//        System.out.println(title860.lemonadeChange(new int[]{5,5,10,10,20}));
//        System.out.println(title860.lemonadeChange(new int[]{5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20}));
//        System.out.println(title860.lemonadeChange(new int[]{5,5,5,10,5,5,10,20,20,20}));
        System.out.println(title860.lemonadeChange(new int[]{5,5,5,10,5,5,10,20,20,20}));
    }
}

package Simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/1/22
 */
public class Title989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int lengthK = (K + "").length(),lengthA = A.length;
        List<Integer> list = new ArrayList<>();
        int i = lengthA - 1,j = lengthK - 1,last = 0;
        while (i >= 0 || j >= 0 || last > 0){
            if (i >= 0 && j >= 0) {
                list.add(0, (A[i] + (K + "").charAt(j) - 48 + last) % 10);
                last = (A[i] + (K + "").charAt(j) - 48 + last) / 10;
                i--;
                j--;
            }else if (i >= 0){
                list.add(0,(A[i] + last) % 10);
                last = (A[i] + last) / 10;
                i--;
            }else if (j >= 0){
                list.add(0,((K + "").charAt(j) - 48 + last) % 10);
                last = ((K + "").charAt(j) - 48 + last) / 10;
                j--;
            }else if (last > 0){
                list.add(0,last);
                last = 0;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Title989 title989 = new Title989();
        System.out.println(title989.addToArrayForm(new int[]{1,2,0,0},34));
        System.out.println(title989.addToArrayForm(new int[]{2,1,5},806));
        System.out.println(title989.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9},1));
        System.out.println(title989.addToArrayForm(new int[]{1,2,3,4},8766));
    }
}

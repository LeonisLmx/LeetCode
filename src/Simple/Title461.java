package Simple;

/**
 * @Author: Urey
 * @Date: 2021/5/27
 */
public class Title461 {

    public int hammingDistance(int x,int y){
        String a = Integer.toBinaryString(x);
        String b = Integer.toBinaryString(y);
        int result = 0;
        for (int i = 0;i < Math.max(a.length(),b.length());i++){
            if (a.length() <= i && b.charAt(i) == '1'){
                result++;
            }else if (b.length() <= i && a.charAt(i) == '1'){
                result++;
            }else if (a.length() > i && b.length() > i && a.charAt(i) != b.charAt(i)){
                result++;
            }
        }
        return result;
    }

    public int hammingDistance2(int x,int y){
        int a = x ^ y, s = 0;
        while (a / 2 > 0){
            if (a % 2 == 1){
                s++;
            }
            a = a / 2;
        }
        return a == 1?s + 1:s;
    }

    public static void main(String[] args) {
        Title461 title461 = new Title461();
        System.out.println(title461.hammingDistance2(3,1));
        System.out.println(3 ^ 1);
        System.out.println(4 ^ 1);
    }
}

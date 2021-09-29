package Middle;

/**
 * @Author: Urey
 * @Date: 2021/4/1
 */
public class Title1006 {

    public int clumsy(int N){
        int temp = 0,a,b,c,d;
        while (N >= 4){
            a = N;
            b = N - 1;
            c = b - 1;
            d = c - 1;
            N -= 4;
            temp = temp == 0?a * b / c + d:temp - a * b / c + d;
        }
        switch (N){
            case 3:
                temp = temp - 6;
                break;
            case 2:
                temp = temp - 2;
                break;
            case 1:
                temp = temp - 1;
                break;
        }
        return temp > 0?temp:-temp;
    }

    public static void main(String[] args) {
        Title1006 title1006 = new Title1006();
        System.out.println(title1006.clumsy(3));
        System.out.println(title1006.clumsy(4));
        System.out.println(title1006.clumsy(10));
    }
}

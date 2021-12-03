package Middle;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/30 10:51 上午
 */
public class Title400 {

    public static int findNthDigit(int n) {
        if (n < 10){
            return n;
        }
        // 从上一个节点的数字往后数几位
        for (int i = 1;i < 32;i++){
            long num = ((long)Math.pow(10,i) - (long)Math.pow(10,i - 1)) * i;
            if (n > num){
                n -= num;
            }else{
                long start = (long)(Math.pow(10,i - 1)) + (n - 1) / i;
                if (n == 0){
                    return 0;
                }
                int count = (n - 1) % i;
                char[] chars = (start + "").toCharArray();
                return chars[count] - 48;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(findNthDigit(10));
//        System.out.println(findNthDigit(9));
//        System.out.println(findNthDigit(11));
//        System.out.println(findNthDigit(15));
//        System.out.println(findNthDigit(1000));
        System.out.println(findNthDigit(1000000000));
    }
}

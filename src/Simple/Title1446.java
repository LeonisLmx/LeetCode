package Simple;

/**
 * @author urey.liu
 * @description
 * @date 2021/12/1 4:14 下午
 */
public class Title1446 {

    public static int maxPower(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length,count = 0,max = 0;
        char last = '0';
        for (int i = 0;i < chars.length;i++){
            if (last == chars[i]){
                count++;
            }else{
                max = Math.max(max,count);
                if (max > len - i){
                    return max;
                }
                count = 1;
                last = chars[i];
            }
        }
        return Math.max(count,max);
    }

    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("s"));
        System.out.println(maxPower("aabbbbbccccdddddddeffffffggghhhhhiiiiijjjkkkkkllllmmmmmnnnnnoopppqrrrrsssttttuuuuvvvvwwwwwwwxxxxxyyyzzzzzzzz"));
    }
}

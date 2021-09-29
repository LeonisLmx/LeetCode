package Hard;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2020/12/24
 */
public class Title135 {

    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]){
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1;i >= 1;i--){
            if (ratings[i] < ratings[i - 1] && candy[i] >= candy[i - 1]){
                    candy[i - 1] = candy[i] + 1;
            }
        }
        System.out.println(Arrays.toString(candy));
        return Arrays.stream(candy).sum();
    }

    public int candy2(int[] ratings){
        // 结果，当前数量，递减序列
        int result = 1,cur = 1,desc = 0;
        for (int i = 1; i < ratings.length; i++) {
            // 第二个数大于第一个数，那么直接++即可
            if (ratings[i] > ratings[i - 1]){
                cur++;
                result = result + cur;
                desc = 0;
            }else if (ratings[i] == ratings[i - 1]){
                result = result + 1;
                cur = 1;
                desc = 0;
            }else{
                desc++;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Title135 title135 = new Title135();
        System.out.println(title135.candy(new int[]{1,0,2}));
        System.out.println(title135.candy(new int[]{1,2,2}));
        System.out.println(title135.candy(new int[]{1,2,87,87,87,2,1}));
        System.out.println(title135.candy(new int[]{1,6,10,8,7,3,2}));
        System.out.println(title135.candy(new int[]{1,3,4,5,2}));
    }
}

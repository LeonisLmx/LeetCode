package Simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author urey.liu
 * @description 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数
 * [1,1,2,3]
 * [1,1,2,2,3,3]
 * @date 2021/11/1 10:22 上午
 */
public class Title575 {

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<Integer>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }

    public static void main(String[] args) {
        Title575 title575 = new Title575();
        System.out.println(title575.distributeCandies(new int[]{1,1,2,2,3,3}));
    }
}

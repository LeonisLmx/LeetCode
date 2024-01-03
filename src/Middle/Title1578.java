package Middle;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/30 5:26 下午
 */
public class Title1578 {

    public static int minCost(String colors, int[] neededTime) {
        int res = 0;
        for (int i = 1;i < colors.length();i++){
            if (colors.charAt(i) == colors.charAt(i - 1)){
                res += Math.min(neededTime[i - 1],neededTime[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minCost("aaabbbabbbb", new int[]{3,5,10,7,5,3,5,5,4,8,1}));
    }
}

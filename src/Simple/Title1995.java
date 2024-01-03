package Simple;

/**
 * @author urey.liu
 * @description
 * @date 2021/12/29 5:29 下午
 */
public class Title1995 {

    public int countQuadruplets(int[] nums){
        int res = 0;
        for (int i = 0;i < nums.length - 3;i++){
            int a = nums[i];
            for (int j = i + 1;j < nums.length - 2;j++){
                int b = a + nums[j];
                for (int x = j + 1;x < nums.length - 1;x++){
                    int c = b + nums[x];
                    for (int y = x + 1;y < nums.length;y++){
                        if (c == nums[y]){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}

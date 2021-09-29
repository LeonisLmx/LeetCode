package Simple;

import javafx.scene.effect.Bloom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/8/4
 */
public class Title611 {

    // 任意两条短边之和大于第三条边就能构成三角形
    public int triangleNumber(int[] nums){
        int length = nums.length;
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0;i < length - 2;i++){
            for (int j = i + 1;j < length - 1;j++){
                int a = nums[i],b = nums[j];
                if (map.containsKey(b)){
                    if (map.get(b) > 0){
                        map.put(b,map.get(b) - 1);
                        result += map.get(b);
                    }
                }else {
                    map.put(b,find(j,nums,a + b));
                    // 二分法查找边界
                    result += map.get(b);
                }
            }
            map.clear();
        }
        return result;
    }

    private int find(int j, int[] nums,int sum) {
        int left = j,right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (mid == left){
                break;
            }
            if (nums[mid] < sum){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left - j;
    }

    public static void main(String[] args) {
        Title611 title611 = new Title611();
        System.out.println(title611.triangleNumber(new int[]{2,2,3,4}));
    }
}

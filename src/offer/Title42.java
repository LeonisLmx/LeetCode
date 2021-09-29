package offer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @Author: Urey
 * @Date: 2021/9/3
 */
public class Title42 {

    public static int maxSubArray(int[] nums){
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int min = 0;
        int max = arr[0];
        for (int i = 1;i < nums.length;i++){
            arr[i] = nums[i] + arr[i - 1];
        }
        for (int i = 0;i < nums.length;i++){
            max = Math.max(max,arr[i] - min);
            min = Math.min(min,arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,-1}));
    }
}

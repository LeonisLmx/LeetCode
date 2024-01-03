package Middle;

/**
 * @author urey.liu
 * @description
 * @date 2022/2/14 3:08 下午
 * 有序数组
 * 1,1,2,3,3,4,4,8,8
 * 2
 */
public class Title540 {

    public int singleNonDuplicate(int[] nums) {
        int end = nums.length - 1,start = 0;
        while (start < end){
            int middle = start + (end - start) / 2;
            if (middle == 0 || middle == nums.length - 1){
                return nums[middle];
            }
            if (nums[middle] == nums[middle - 1]){
                if (middle % 2 == 0) {
                    end = middle - 1;
                }else{
                    start = middle + 1;
                }
            }else if (nums[middle] == nums[middle + 1]){
                if (middle % 2 == 0) {
                    start = middle + 1;
                }else{
                    end = middle - 1;
                }
            }else{
                return nums[middle];
            }
        }
        return nums[start];
    }

    public int middleSearch(int a, int[] nums){
        int start = 0, end = nums.length - 1;
        while (start < end){
            int middle = start + (end - start) / 2;
            if (nums[middle] == a){
               return middle;
            }else if (nums[middle] > a){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Title540 title540 = new Title540();
//        System.out.println(title540.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
//        System.out.println(title540.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
//        System.out.println(title540.singleNonDuplicate(new int[]{3,3,7,7,10,10,11,11,12}));
//        System.out.println(title540.singleNonDuplicate(new int[]{1,3,3,7,7,10,10,11,11}));
        System.out.println(title540.singleNonDuplicate(new int[]{1,2,2,3,3}));
//        System.out.println(title540.middleSearch(1,new int[]{1,2,3,4,5,6,7,8,9,10}));
//        System.out.println(title540.middleSearch(10,new int[]{1,2,3,4,5,6,7,8,9,10}));
//        System.out.println(title540.middleSearch(6,new int[]{1,2,3,4,5,6,7,8,9,10}));
    }
}

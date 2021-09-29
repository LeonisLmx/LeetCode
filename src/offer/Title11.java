package offer;

/**
 * @Author: Urey
 * @Date: 2020/12/22
 */
public class Title11 {

    public int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }

    public int minArrays(int[] numbers){
        int start = 0,end = numbers.length-1;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (numbers[middle] < numbers[end]){
                end = middle;
            }else if (numbers[middle] > numbers[end]){
                start = middle + 1;
            }else{
                end = end - 1;
            }
        }
        return numbers[start];
    }

    public static void main(String[] args) {
        Title11 title11 = new Title11();
        //System.out.println(title11.minArray(new int[]{4,5,6,1,2,3}));
        System.out.println(title11.minArrays(new int[]{4,5,6,1,2,3}));
        System.out.println(title11.minArrays(new int[]{1,0,1,1,1}));
        System.out.println(title11.minArray(new int[]{1,0,1,1,1}));
    }
}

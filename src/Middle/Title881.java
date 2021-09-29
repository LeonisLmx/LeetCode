package Middle;

import java.util.Arrays;

/**
 * @Author: Urey
 * @Date: 2021/8/26
 */
public class Title881 {

    public static int numRescueBoats(int[] people,int limit){
        Arrays.sort(people);
        int count = 0,start = 0,end = people.length - 1;
        while (start <= end){
            if (people[start] + people[end] <= limit){
                start++;
            }
            // 如果head和tail的和大于limit，那么tail的数据可以自己成立一条船即可
            end--;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1,2},3));
        System.out.println(numRescueBoats(new int[]{3,2,2,1},3));
        System.out.println(numRescueBoats(new int[]{3,5,3,4},5));
        System.out.println(numRescueBoats(new int[]{3,1,7},7));
    }
}

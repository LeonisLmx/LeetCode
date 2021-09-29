package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/7/2
 */
public class Title1833 {
    public int maxIceCream(int[] costs, int coins) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int cost : costs) {
            int value = map.getOrDefault(cost,0);
            map.put(cost,value + 1);
            if (value  == 0) {
                list.add(cost);
            }
        }
        Collections.sort(list);
        int count = 0;
        for (Integer index : list) {
            int num = map.get(index);
            if (num * index > coins){
                while (num > 0 && index <= coins){
                    coins = coins - index;
                    num--;
                    count++;
                }
            }else{
                coins = coins - num * index;
                count = count + num;
            }
        }
        return count;
    }

    private void quickSort(int[] costs,int left,int right) {
        if (left > right){
            return;
        }
        int current = costs[left];
        int i = left,j = right;
        while (i < j){
            while (i < j && current <= costs[j]){
                j--;
            }
            while (i < j && current >= costs[i]){
                i++;
            }
            if (i < j){
                swap(costs,i,j);
            }
            System.out.println(Arrays.toString(costs));
        }
        costs[left] = costs[i];
        costs[i] = current;
        System.out.println(Arrays.toString(costs));
        quickSort(costs,left,i - 1);
        quickSort(costs,i + 1,right);
    }

    private void swap(int[] costs, int i, int left) {
        int temp = costs[i];
        costs[i] = costs[left];
        costs[left] = temp;
    }

    private void selectSort(int[] costs){
        for (int i = 0;i < costs.length;i++){
            int temp = costs[i],a = i;
            for (int j = i;j < costs.length;j++){
                if (temp > costs[j]){
                    temp = costs[j];
                    a = j;
                }
            }
            swap(costs,i,a);
        }
    }

    private void insertSort(int[] costs){
        int length = costs.length;
        int[] arr = new int[length];
        arr[0] = costs[0];
        for (int i = 1;i < length;i++){
            for (int j = i;j >= 0;j--){
                if (arr[j] < costs[i]){

                }
            }
        }
    }

    public static void main(String[] args) {
        Title1833 title1833 = new Title1833();
        //System.out.println(title1833.maxIceCream(new int[]{1,3,2,4,1},7));
        int[] cost = new int[]{7,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(title1833.maxIceCream(new int[]{4,7,6,4,4,2,2,4,8,8},41));
        //title1833.quickSort(cost,0,cost.length - 1);
        title1833.selectSort(cost);
        System.out.println(Arrays.toString(cost));
    }
}

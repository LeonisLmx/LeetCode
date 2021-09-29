package Simple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author: Urey
 * @Date: 2021/7/23
 */
public class Title1893 {

    public boolean isCovered(int[][] ranges,int left,int right){
        int length = ranges.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < length;i++){
            for (int j = ranges[i][0];j <= ranges[i][1];j++){
                set.add(j);
            }
        }
        while (left <= right){
            if (!set.contains(left)){
                return false;
            }
            left++;
        }
        return true;
    }

    public boolean isCovered2(int[][] ranges,int left,int right){
        int length = ranges.length;
        boolean leftOpen = false,rightOpen = false;
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for (int i = 0;i < length;i++){
            if (ranges[i][0] > right || ranges[i][1] < left){
                continue;
            }
            if (ranges[i][0] <= left && ranges[i][1] >= left){
                left = ranges[i][1] + 1;
                leftOpen = true;
            }
            if (ranges[i][0] <= right && ranges[i][1] >= right){
                right = ranges[i][0] - 1;
                rightOpen = true;
            }
            if (leftOpen && rightOpen && right < left){
                return true;
            }
        }
        return false;
    }

    // 差分算法
    public boolean isCovered3(int[][] ranges,int left,int right){
        int[] diff = new int[52];
        for (int i = 0;i < ranges.length;i++){
            diff[ranges[i][0]]++;
            diff[ranges[i][1] + 1]--;
        }
        int sum = diff[0];
        for (int i = 1;i <= right;i++){
            sum += diff[i];
            if (i >= left){
                if (sum <= 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Title1893 title1893 = new Title1893();
        System.out.println(title1893.isCovered3(new int[][]{{1,2},{3,4},{5,6}},2,5));
        System.out.println(title1893.isCovered3(new int[][]{{3,25},{13,23},{7,14},{37,44},{28,38},{13,32},{7,43},{19,25},{32,33}},2,21));
    }
}

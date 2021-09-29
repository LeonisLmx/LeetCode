package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: Urey
 * @Date: 2021/6/29
 */
public class Title491 {

    public List<List<Integer>> findSubsequences(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 2){
            return lists;
        }
        if (nums.length == 2){
            if (nums[0] < nums[1]){
                lists.add(Arrays.asList(nums[0],nums[1]));
            }
            return lists;
        }
        Set<List<Integer>> set = new HashSet<>();
        dfs(nums,0, -101,set,new LinkedList<>());
        return new ArrayList<>(set);
    }

    private void dfs(int[] nums, int start, int last, Set<List<Integer>> set, Queue<Integer> queue) {
        for (int i = start;i < nums.length;i++){
            if (last > nums[i]){
                continue;
            }
            queue.offer(nums[i]);
            if (queue.size() >= 2){
                set.add(new ArrayList<>(queue));
            }
            dfs(nums,i + 1, nums[i],set,queue);
            queue.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        Title491 title491 = new Title491();
        System.out.println(title491.findSubsequences(new int[]{4,6,7,7}));
        System.out.println(title491.findSubsequences(new int[]{4,4,3,2,1}));
        System.out.println(title491.findSubsequences(new int[]{1,3,5,7}));
    }
}

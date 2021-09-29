package Middle;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2020/12/3
 */
public class Title40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(lists,path,candidates,0,target);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, Deque<Integer> path, int[] candidates, int start, int target) {
        if (target < 0){
            return;
        }
        if (target == 0){
//            List<Integer> list = new ArrayList<>(path);
//            Collections.sort(list);
//            if (!lists.contains(list)){
//                lists.add(list);
//            }
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int j = start; j < candidates.length; j++) {
            if (target - candidates[j] < 0){
                break;
            }

            if (j > start && candidates[j] == candidates[j - 1]) {
                continue;
            }

            path.add(candidates[j]);

            dfs(lists, path, candidates, j + 1, target - candidates[j]);

            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Title40 title40 = new Title40();
        System.out.println(title40.combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}

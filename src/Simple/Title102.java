package Simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/1 2:38 下午
 */
public class Title102 {

    Map<Integer, List<Integer>> map = new HashMap<>();

    int max = 0;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0);
        for (int i = 0;i < max; i++){
            list.add(map.get(i));
        }
        return list;
    }

    private void dfs(TreeNode root, Integer level) {
        if (root == null){
            return;
        }
        List<Integer> list = map.getOrDefault(level, new ArrayList<>());
        list.add(root.val);
        map.put(level, list);
        level = level + 1;
        max = Math.max(max, level);
        dfs(root.left, level);
        dfs(root.right, level);
    }
}
